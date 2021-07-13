// Login --------------------------------------------------------------------------------
function validateUsername() {
    const username = $("#username").val();
    const regexp = /^[a-zA-Z. \-]{2-20}$/;
    const ok = regexp.test(username)
    if (!ok){
        $("#wrongUsername").html("Username must consist of 2-20 characters");
        return false;
    } else {
        $("#wrongUsername").html("");
        return true;
    }
}

function validatePwd(){
    const password = $("#password").val();
    const regexp = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
    const ok = regexp.test(password);
    if (!ok){
        $("#wrongPass").html("Password must include at least 8 characters, " +
            "at least one letter and one number");
        return false;
    } else {
        $("#wrongPass").html("");
        return true;
    }
}

function loginValidationOK(){
    return (validatePwd() && validateUsername());
}


// Hour registration --------------------------------------------------------------------
function validateProject(){
    const project = $("#project").val();
    const regexp = /^[A-Z]{3}[0-9]{3}$/;
    const ok = regexp.test(project);
    if (!ok){
        $("#invalidProjectName").html("Please write a valid project number in the style XYZ123");
        return false;
    } else {
        $("#invalidProjectName").html("");
        return true;
    }
}

function validateHours(){
    const hours = $("#numberHours").val();
    const regexp = /^[1-9]{1,2}$/;
    const ok = regexp.test(hours);
    if (!ok) {
        $("#floats").html("Please write a whole number, 1-99")
        return false;
    } else {
        $("#floats").html("")
        return true;
    }
}

function registrationOK() {
    return (validateProject() && validateHours());
}