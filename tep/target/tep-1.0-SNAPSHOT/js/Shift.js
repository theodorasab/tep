
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
        if (user == "employee") {
            $('#replace').load('Shift.html');
        }

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


function replaceShift() {
    var data = new FormData();
    data.append('rpAT', $("#rATshift").val());
    data.append('withAT', $("#rATshift1").val());
    data.append('withName', $("#rFN1").val());
    data.append('withProfession', $("#Profession2").val());
    data.append('withDate', $("#rDateshift1").val());
    data.append('withShift', $("#rShiftTime1").val());

    ajaxRequest('POST', 'http://localhost:8080/tep/replaceShift', data, function (o) {
        var res = JSON.parse(o.responseText);
        console.log(res);
        $("#rdoctormessage").html("Succesfully updated the doctor in shift.")
    }, function (o) {
        if (o.readyState == 4) {
            $("r#doctormessage").html("This doctor already exists in this shift.")
        }
    });
}

