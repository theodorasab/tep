$(document).ready(function () {
    load();
});

function load() {
    $("#addWorker").click(function () {
        createShift();
    });
}

function createShift() {
    var tbl = "";

    tbl = "<table>" +
            "<tr>" +
            "<th> Full Name </th>" +
            "<th> AT </th>" +
            "<th> Profession </th>" +
            "<th> Date </th>" +
            "<th> Shift Hours</th>" +
            "</tr>";
    for (i = 0; i < 14; i++) {
        tbl += "<tr>" +
                "<td>" + i + "</td>" +
                "<td>" +
                "<input type='text' id='FullName' name='FName'>" +
                "</td>" +
                "<td>" +
                "<input type='text' id='AT' name='AT'>" +
                "</td>" +
                "<td>" +
                "<input type='text' id='Profession' name='Profession'>" +
                "</td>" +
                "<td>" +
                "<input type='text' id='Date' name='Date'>" +
                "</td>" +
                "<td>" +
                "<input type='text' id='ShiftTime' name='ShiftTime'><br>" +
                "</td>" +
                "</tr>";
    }
    tbl += "</table>";

    $("#").append(tbl);
}

