function login() {
    if (loginValidationOK()){
        const url = "/login?username="+$("#username").val()+"&password="+$("#password").val();

        $.get( url, function( OK) {
            if(OK){
                window.location.href="registration.html";
            }
            else {
                $("#err").html("Wrong username or password");
            }
        })
            .fail(function (jqXHR) {
                const json = $.parseJSON(jqXHR.responseText);
                $("#err").html(json.message);
            });
    }
}