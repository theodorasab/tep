//
//function load() {
//    $("#addWorker").click(function () {
//        createShift();
//    });
//}

function addShift() {

    var data = new FormData();
    data.append('full_name', $("#FullName").val());
    data.append('AT', $("#ATshift").val());
    data.append('profession', $("#Profession").val());
    data.append('date', $("#Dateshift").val());
    data.append('shift', $("#ShiftTime").val());
    ajaxRequest('POST', 'http://localhost:8080/tep/addShift', data, function (o) {
        var res = JSON.parse(o.responseText);
        $("#doctormessage").html("Succesfully added the doctor in shift.")
    }, function (o) {
        if (o.readyState == 4) {
            $("#doctormessage").html("This doctor already exists in this shift.")
        }
    });
}

function getShift() {
    ajaxRequest('GET', 'http://localhost:8080/tep/seeShift', undefined, function (o) {
        var res = JSON.parse(o.responseText);
        console.log(res);
        var shift = "<table>" +
                "<tr>" +
                "<th> Full Name </th>" +
                "<th> Profession </th>" +
                "<th> Date </th>" +
                "<th> Shift</th>" +
                "</tr>";
        for (i = 0; i < res.length; i++) {
            shift += "<tr>" +
                    "<td>" + res[i].full_name + "</td>" +
                    "<td>" + res[i].profession + "</td>" +
                    "<td>" + res[i].date + "</td>" +
                    "<td>" + res[i].hours + "</td>" +
                    "</tr>";
        }
        shift += "</table>";

        $("#content_page").html(shift);

    });
}


//function createShift() {
//    var tbl = "";
//
//    tbl = "<table>" +
//            "<tr>" +
//            "<th> Full Name </th>" +
//            "<th> AT </th>" +
//            "<th> Profession </th>" +
//            "<th> Date </th>" +
//            "<th> Shift Hours</th>" +
//            "</tr>";
//    for (i = 0; i < 14; i++) {
//        tbl += "<tr>" +
//                "<td>" + i + "</td>" +
//                "<td>" +
//                "<input type='text' id='FullName' name='FName'>" +
//                "</td>" +
//                "<td>" +
//                "<input type='text' id='AT' name='AT'>" +
//                "</td>" +
//                "<td>" +
//                "<input type='text' id='Profession' name='Profession'>" +
//                "</td>" +
//                "<td>" +
//                "<input type='text' id='Date' name='Date'>" +
//                "</td>" +
//                "<td>" +
//                "<input type='text' id='ShiftTime' name='ShiftTime'><br>" +
//                "</td>" +
//                "</tr>";
//    }
//    tbl += "</table>";
//
//    $("#").append(tbl);
//}

