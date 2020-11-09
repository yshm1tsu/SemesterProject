function ValidateEmail(inputText)
{
    var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if(!inputText.value.match(mailformat))
    {
        alert("You have entered an invalid email address!");
        document.form1.text1.focus();
        return false;
    }
}
function ValidatePassword(inputText1, inputText2){
    if(inputText1.value<5){
        alert("password should contain 5 or more charachters!");
        document.form1.text1.focus();
        return true;
    }
    if(inputText1!==inputText2){
        alert("passwords doesnt match");
        return true;
    }
}