$(function (){ // Ready function
    getHours();
});

function getHours(){
    $.get("/getHours", function(hours){
        formatHours(hours);
        })
        .fail(function (jqXHR){
            const json = $.parseJSON(jqXHR.responseText);
            $("#err").html(json.message);
        });
}

function formatHours(hours){  // Create a table of all registered hours
    let total = 0;
    let out = "<table class='table table-striped'><tr><th>Project</th><th>Date</th><th>Hours</th><th>Comment</th></tr>";
    for (const hour of hours){
        total += hour.hours;
        out += "<tr><td>" + hour.project + "</td><td>" + hour.date + "</td><td>" + hour.hours + "</td><td>" + hour.comment + "</td><td>" +
            "<button class='btn btn-danger' onclick='deleteHours("+ hour + ")'>Delete</button></td></tr>"
    }
    out += "</table>";
    $("#hours").html(out);
    if (total > 100){ // Warning only given when hours strictly exceed 100
        $("#overworked").html("Total hours exceed 100!")
    } else {
        $("#overworked").html("");
    }
}

function deleteHours(hour){
    const url = "/deleteHours?hours="+hour;
    //TODO create this method in controller + repo
    $.delete(url, function (){
        window.location.href = "registration.html";
    });
}

function save(){
    if (registrationOK()){
        const hour = {
            project : $("#project").val(),
            date: $("#date").val(),
            hours : $("#numberHours").val(),
            comment : $("#comment").val(),
        };

        $.post("/save", hour, function (){
            getHours();
        });

        window.location.href = "registration.html";
    }
}