'user strict';


function addPatient() {
    var selected = $("#symptoms :selected").val(); // The value of the selected option
    var data = new FormData();
    data.append('full_name', $("#FName").val());
    data.append('address', $("#address").val());
    data.append('amka', $("#AMKA").val());
    data.append('insurance', $("#insurance").val());
    data.append('diseases', $("#chDisease").val());
    data.append('selected_symptoms', selected);
    data.append('symptoms', $("#moresymptoms").val());

    ajaxRequest('POST', 'http://localhost:8080/tep/addPatient', data, function (o) {
        var res = JSON.parse(o.responseText);
        $('#content_page').load('patientinfo.html', function () {
            $("#FName").val(res.full_name)
            $("#address").val(res.address);
            $("#AMKA").val(res.amka);
            $("#insurance").val(res.insurance);
            $("#chDisease").val(res.diseases);
            $("#symptoms").val(selected);
            $("#moresymptoms").val($("#moresymptoms").val());

            if (selected == 1)
                $("#doctor").val("Surgeon");
            else if (selected == 2)
                $("#doctor").val("Surgeon");
            else if (selected == 3)
                $("#doctor").val("Surgeon");
            else if (selected == 4)
                $("#doctor").val("Pediatrician");
            else if (selected == 5)
                $("#doctor").val("Ophthalmologist");
            else if (selected == 6)
                $("#doctor").val("Ophthalmologist");
            else if (selected == 7)
                $("#doctor").val("Ophthalmologist");

            else if (selected == 8)
                $("#doctor").val("Pathologist");

            else if (selected == 9)
                $("#doctor").val("Pathologist");

            else if (selected == 10)
                $("#doctor").val("Pathologist");

            else if (selected == 11)
                $("#doctor").val("Orthopedician");

            else if (selected == 12)
                $("#doctor").val("Orthopedician");

            var data1 = new FormData();
            data1.append('doctor', $("#doctor").val());
            data1.append('amka', $("#AMKA").val());
            ajaxRequest('POST', 'http://localhost:8080/tep/setDoctor', data1, function (o) {});

            $("#message").html("Succesfully added the patient");
            $('#message').css('color', 'green');
            $('#doctor').css('display', 'inline');
            $('#doctorlabel').css('display', 'inline');
            $('#submitpatient').css('display', 'none');
            $('#submitdiagnose').css('display', 'none');
            $('#submitexam').css('display', 'none');
            $('#therapy').css('display', 'none');
            $('#diagnose').css('display', 'none');
            $('#therapylabel').css('display', 'none');
            $('#diagnoselabel').css('display', 'none');
            $('#prescription').css('display', 'none');
            $('#examinations').css('display', 'none');
            $('#prescriptionlabel').css('display', 'none');
            $('#examinationslabel').css('display', 'none');
            $('#report').css('display', 'none');
            $('#reportlabel').css('display', 'none');


        });


    }, function (o) {
        if (o.readyState == 4) {
            var res = JSON.parse(o.responseText);
            $('#content_page').load('patientinfo.html', function () {
                $("#FName").val(res.full_name)
                $("#address").val(res.address);
                $("#AMKA").val(res.amka);
                $("#insurance").val(res.insurance);
                $("#chDisease").val(res.diseases);
                $("#symptoms").val(selected);
                $("#moresymptoms").val($("#moresymptoms").val());

                if (selected == 1)
                    $("#doctor").val("Surgeon");
                else if (selected == 2)
                    $("#doctor").val("Surgeon");
                else if (selected == 3)
                    $("#doctor").val("Surgeon");
                else if (selected == 4)
                    $("#doctor").val("Pediatrician");
                else if (selected == 5)
                    $("#doctor").val("Ophthalmologist");
                else if (selected == 6)
                    $("#doctor").val("Ophthalmologist");
                else if (selected == 7)
                    $("#doctor").val("Ophthalmologist");

                else if (selected == 8)
                    $("#doctor").val("Pathologist");

                else if (selected == 9)
                    $("#doctor").val("Pathologist");

                else if (selected == 10)
                    $("#doctor").val("Pathologist");

                else if (selected == 11)
                    $("#doctor").val("Orthopedician");

                else if (selected == 12)
                    $("#doctor").val("Orthopedician");

                var data1 = new FormData();
                data1.append('doctor', $("#doctor").val());
                data1.append('amka', $("#AMKA").val());
                ajaxRequest('POST', 'http://localhost:8080/tep/setDoctor', data1, function (o) {});

                $('#doctor').css('display', 'inline');
                $('#doctorlabel').css('display', 'inline');
                $("#message").html("Patient's folder already exist");
                $('#message').css('color', 'red');
                $('#submitpatient').css('display', 'inline');
                $('#submitdiagnose').css('display', 'none');
                $('#submitexam').css('display', 'none');
                $('#therapy').css('display', 'none');
                $('#diagnose').css('display', 'none');
                $('#therapylabel').css('display', 'none');
                $('#diagnoselabel').css('display', 'none');
                $('#prescription').css('display', 'none');
                $('#examinations').css('display', 'none');
                $('#prescriptionlabel').css('display', 'none');
                $('#examinationslabel').css('display', 'none');
                $('#report').css('display', 'none');
                $('#reportlabel').css('display', 'none');


            });

        }
    });

}


function getPatient() {

    var data = new FormData();
    data.append('doctor', "Surgeon");

    ajaxRequest('GET', 'http://localhost:8080/tep/getPatient', data, function (ο) {
        var res = JSON.parse(ο.responseText);
        $("#FName").val(res.full_name);
        $("#AMKA").val(res.amka);
        $("#insurance").val(res.insurance);
        $("#chDisease").val(res.diseases);
        $('#symptoms').val(res.selected_symptoms);
        $("#moresymptoms").val(res.symptoms);
        var data1 = new FormData();
        data1.append('amka', res.amka);
        ajaxRequest('GET', 'http://localhost:8080/tep/getExam', data1, function (ο) {
            var res1 = JSON.parse(ο.responseText);
            $("#diagnose").val(res1.diagnose);
            $("#examinations").val(res1.exam_order);

        });


        if (res.report != "") {
            $('#report').val(res.report);
        } else {

            $('#reportlabel').css('display', 'none');
            $('#report').css('display', 'none');
        }
        $('#submitexam').css('display', 'none');

    });

}


function getUsers() {
    var data = new FormData();
    data.append('username', $("#username").val());
    ajaxRequest('GET', 'http://localhost:8080/tep/getTepUsers', data, function (ο) {
        var res = JSON.parse(ο.responseText);
        if (res == "patient") {
            $('#addPatient').css('display', 'inline');
            $('#seePatients').css('display', 'none');
            $('#logout').css('display', 'inline');
            $('#signin').css('display', 'none');
            $('#addShift').css('display', 'none');
            $('#seeShift').css('display', 'inline');
        } else if (res == "surgeon") {
            $('#addPatient').css('display', 'none');
            $('#seePatients').css('display', 'inline');
            $('#logout').css('display', 'inline');
            $('#signin').css('display', 'none');
            $('#addShift').css('display', 'none');
            $('#seeShift').css('display', 'inline');
        } else if (res == "nurse") {
            $('#searchPatient').css('display', 'inline');
            $('#seePatients').css('display', 'none');
            $('#addPatient').css('display', 'none');
            $('#logout').css('display', 'inline');
            $('#signin').css('display', 'none');
            $('#addShift').css('display', 'none');
            $('#seeShift').css('display', 'inline');
        } else if (res == "employee") {
            $('#searchPatient').css('display', 'none');
            $('#seePatients').css('display', 'none');
            $('#addPatient').css('display', 'none');
            $('#logout').css('display', 'inline');
            $('#signin').css('display', 'none');
            $('#addShift').css('display', 'inline');
            $('#seeShift').css('display', 'inline');
        }
    });
}