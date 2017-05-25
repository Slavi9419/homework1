/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vatahov.mywebproject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnError;
import javax.websocket.Session;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Slavi Vatahov
 */
@ServerEndpoint("/home")
public class GameServerEndpoint {

    Authentication authentication;
    static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    @OnClose
    public void onClose() {
        userUsernameMap.remove(session);
    }

    @OnMessage
    public void onMessage(String message) {

        if (message.startsWith("S,I,G,N,I,N")) {
            String authenticationParam = message.substring(12);
            String userParamArg[] = authenticationParam.split(",");
            authentication(userParamArg[0], userParamArg[1]);
        } else if (message.startsWith("S,I,G,N,U,P")) {
            String registration = message.substring(12);
            String userParamArg[] = registration.split(",");
            registration(userParamArg[0], userParamArg[1], userParamArg[2], userParamArg[3], userParamArg[4]);
        } else if (message.startsWith("R,E,F,R,E,S,H,R,O,O,M,S")) {
            sendUserListToClient();
        }
    }

    @OnError
    public void onError(Throwable t) {

    }

    private void sendMessageToClient(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            Logger.getLogger(GameServerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void authentication(String username, String password) {
        try {
            authentication = new Authentication(username, password);
            boolean isLogin = authentication.checkSignIn();
            if (isLogin) {
                sendMessageToClient("L,O,G,I,N,S,U,C,C,E,S,S");
                userUsernameMap.put(session, username);
            } else {
                sendErrorMsg("Invalid username or password");
            }
        } catch (NamingException ex) {
            sendErrorMsg("Error Lookup! Failed connection to database.");
        } catch (SQLException ex) {
            sendErrorMsg("Error " + ex.getMessage());
        }
    }

    private void registration(String firstName, String lastName, String username, String email, String password) {
        try {
            authentication = new Authentication(firstName, lastName, username, email, password);
            boolean checkUser = authentication.checkingTheUserInDatabase();
            if (!checkUser) {
                boolean isCreate = authentication.createNewAcount();
                if (isCreate) {
                    userUsernameMap.put(session, username);
                    sendMessageToClient("R,E,G,I,S,T,R,A,T,I,O,N,S,U,C,C,E,S,S");
                }
            } else {
                sendErrorMsg("Username or email is Occupied!");
            }
        } catch (NamingException ex) {
            sendErrorMsg("Error Lookup! Failed connection to database.");
        } catch (SQLException ex) {
            sendErrorMsg("Error " + ex.getMessage());
        }
    }

    private void sendUserListToClient() {
        //  userUsernameMap.keySet().stream().forEach((/*Session*/ session1) -> {
        try {
            this.session.getBasicRemote().sendText(String.valueOf(new JSONObject().put("userlist", userUsernameMap.values())));
        } catch (JSONException e) {
        } catch (IOException ex) {
            Logger.getLogger(GameServerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
        // });
    }

    private void sendErrorMsg(String msg) {
        try {
            session.getBasicRemote().sendText("E,R,R,O,R" + msg);
        } catch (IOException ex) {
            Logger.getLogger(GameServerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
