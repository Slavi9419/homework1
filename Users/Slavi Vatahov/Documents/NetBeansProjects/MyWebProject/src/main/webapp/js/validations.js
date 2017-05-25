function ValidateEmail(inputText)
{
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (inputText.value.match(mailformat))
    {
        return firstNameRequired()()();
    } else
    {
        alert("You have entered an invalid email address!");
        document.form1.text1.focus();
        return false;
    }
}
function usernameRequired()
{
    var empt = document.getElementById('singUpUsernameID').value;
    if (empt == "")
    {
        alert("Please input a Username");
        return false;
    } else
    {
        return passwordLenght(document.form1.singUpPassword, 6, 8);
    }

}
function firstNameRequired()
{
    var empt = document.getElementById('singUpFirstNameID').value;
    if (empt == "")
    {
        alert("Please input a firstName");
        return false;
    } else
    {
        return lastNameRequired();
    }

}
function lastNameRequired()
{
    var empt = document.getElementById('singUpLastNameID').value;
    if (empt == "")
    {
        alert("Please input a lastName");
        return false;
    } else
    {
        return usernameRequired();
    }

}
function passwordLenght(inputtxt, minlength, maxlength)
{
    var field = inputtxt.value;
    var mnlen = minlength;
    var mxlen = maxlength;

    if (field.length < mnlen || field.length > mxlen)
    {
        alert("Please input the password between " + mnlen + " and " + mxlen + " characters");
        return false;
    } else
    {

        return singUp();
    }
}
function usernameOrEmailRequired()
{
    var empt = document.getElementById('loginUsernameID').value;
    if (empt == "")
    {
        alert("Please input a username or email");
        return false;
    } else
    {
        return loginPasswordRequied();
    }

}
function loginPasswordRequied()
{
    var empt = document.getElementById('loginPasswordID').value;
    if (empt == "")
    {
        alert("Please input a password");
        return false;
    } else
    {
        return signIn();
    }

}