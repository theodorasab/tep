
function getPatientsForExams() {
    ajaxRequest('GET', 'http://localhost:8080/tep/getAllPatientsForExams', undefined, function (o) {
        var res = JSON.parse(o.responseText);

        var list = "<table>" +
                "<tr>" +
                "<th> AMKA </th>" +
                "<th> Exam Order </th>" +
                "<th> Diagnose </th>" +
                "</tr>";
        for (i = 0; i < res.length; i++) {
            list += "<tr>" +
                    "<td>" + res[i].amka + "</td>" +
                    "<td>" + res[i].exam_order + "</td>" +
                    "<td>" + res[i].diagnose + "</td>" +
                    "</tr>";
        }
        list += "</table>";

        $("#showPatients").html(list);
    });
}







function addDiagnose() {

    var data = new FormData();
    data.append('amka', $("#AMKA").val());
    data.append('diagnose', $("#diagnose").val());
    data.append('exam_order', $("#examinations").val());
    data.append('prescription', $("#nameph").val());
    data.append('therapy', $("#therapy").val());

    data.append('nameph', $("#nameph").val());
    data.append('typeph', $("#typeph").val());
    data.append('doseph', $("#doseph").val());
    data.append('illnessph', $("#illnessph").val());
    ajaxRequest('POST', 'http://localhost:8080/tep/addDiagnose', data, function (o) {
        var res = JSON.parse(o.responseText);
        $('#content_page').html("<div style=" + "color:green; float:center;" + " >Succesfully submitted diagnose</div>")
    });

    ajaxRequest('POST', 'http://localhost:8080/tep/addDrug', data, function (o) {
        var res = JSON.parse(o.responseText);
    });
}

function searchPatient() {
    if (user == "nurse") {
        var data = new FormData();
        data.append('amka', $("#search").val());
        ajaxRequest('GET', 'http://localhost:8080/tep/getExam', data, function (o) {
            var res = JSON.parse(o.responseText);
            $('#content_page').load('patientinfo.html', function () {
                $("#AMKA").val(res.amka);
                $("#diagnose").val(res.diagnose);
                $("#examinations").val(res.exam_order);

                $('#illnessphlabel').css('display', 'none');
                $('#namephlabel').css('display', 'none');
                $('#typephlabel').css('display', 'none');
                $('#dosephlabel').css('display', 'none');
                $('#nameph').css('display', 'none');
                $('#typeph').css('display', 'none');
                $('#doseph').css('display', 'none');
                $('#illnessph').css('display', 'none');
                $('#FName').css('display', 'none');
                $('#address').css('display', 'none');
                $('#moresymptoms').css('display', 'none');
                $('#symptoms').css('display', 'none');
                $('#symptomslabel').css('display', 'none');
                $('#moresymptomslabel').css('display', 'none');
                $('#chDiseaselabel').css('display', 'none');
                $('#chDisease').css('display', 'none');
                $('#chDiseaselabel').css('display', 'none');
                $('#report').css('display', 'inline-block');
                $('#reportlabel').css('display', 'inline-block');
                $('#submitdiagnose').css('display', 'none');
                $('#FNamelabel').css('display', 'none');
                $('#submitpatient').css('display', 'none');
                $('#doctor').css('display', 'none');
                $('#addres').css('display', 'none');
                $('#addresslabel').css('display', 'none');
                $('#insurance').css('display', 'none');
                $('#insurancelabel').css('display', 'none');
                $('#doctorlabel').css('display', 'none');
                $('#therapy').css('display', 'none');
                $('#diagnose').css('display', 'inline');
                $('#therapylabel').css('display', 'none');
                $('#diagnoselabel').css('display', 'inline-block');
                $('#prescription').css('display', 'none');
                $('#examinations').css('display', 'inline-block');
                $('#prescriptionlabel').css('display', 'none');
                $('#examinationslabel').css('display', 'inline-block');
                $('#submitdiagnose').css('display', 'none');
                $('#submitexams').css('display', 'none');
                $('#update').css('display', 'inline');
                $('#submitpatient').css('display', 'none');

            });

        });
    }

    var data = new FormData();
    data.append('amka', $("#search").val());
    ajaxRequest('GET', 'http://localhost:8080/tep/getExam', data, function (o) {
        var res = JSON.parse(o.responseText);
        ajaxRequest('GET', 'http://localhost:8080/tep/getMyPatient', data, function (o) {
            var res1 = JSON.parse(o.responseText);
            $('#content_page').load('patientinfo.html', function () {
                $("#AMKA").val(res1.amka);
                document.getElementById('AMKA').setAttribute('readonly', true)
                document.getElementById('moresymptoms').setAttribute('readonly', true)
                document.getElementById('diagnose').setAttribute('readonly', true)
                document.getElementById('examinations').setAttribute('readonly', true)
                document.getElementById('report').setAttribute('readonly', true)
                document.getElementById('nameph').setAttribute('readonly', true)
                document.getElementById('doseph').setAttribute('readonly', true)
                document.getElementById('typeph').setAttribute('readonly', true)
                document.getElementById('doseph').setAttribute('readonly', true)
                document.getElementById('illnessph').setAttribute('readonly', true)
                document.getElementById('therapy').setAttribute('readonly', true)
                $("#diagnose").val(res.diagnose);
                $("#examinations").val(res.exam_order);
                $("#FName").val(res1.full_name);
                $("#address").val(res1.address);
                $("#insurance").val(res1.insurance);
                $("#chDisease").val(res1.diseases);
                $("#moresymptoms").val(res1.symptoms);
                $("#doctor").val(res1.doctor);
                $("#report").val(res.report);
                $("#therapy").val(res.therapy);
                $("#nameph").val(res.prescription);
                $('#submitdiagnose').css('display', 'none');
                $('#submitexam').css('display', 'none');
                $('#submitpatient').css('display', 'none');
                $('#update').css('display', 'inline');
            });
        });


    });


}



function addReport() {

    var data = new FormData();
    data.append('amka', $("#AMKA").val());
    data.append('report', $("#report").val());

    ajaxRequest('POST', 'http://localhost:8080/tep/addReport', data, function (o) {
        var res = JSON.parse(o.responseText);
        $("#AMKA").val(res.amka);
        $("#diagnose").val(res.diagnose);
        $("#examinations").val(res.exam_order);
        $("#report").val(res.report);
        $('#FName').css('display', 'none');
        $('#address').css('display', 'none');
        $('#moresymptoms').css('display', 'none');
        $('#symptoms').css('display', 'none');
        $('#symptomslabel').css('display', 'none');
        $('#moresymptomslabel').css('display', 'none');
        $('#chDiseaselabel').css('display', 'none');
        $('#chDisease').css('display', 'none');
        $('#chDiseaselabel').css('display', 'none');
        $('#report').css('display', 'inline-block');
        $('#reportlabel').css('display', 'inline-block');
        $('#submitdiagnose').css('display', 'none');
        $('#FNamelabel').css('display', 'none');
        $('#submitpatient').css('display', 'none');
        $('#doctor').css('display', 'none');
        $('#addres').css('display', 'none');
        $('#addresslabel').css('display', 'none');
        $('#insurance').css('display', 'none');
        $('#insurancelabel').css('display', 'none');
        $('#doctorlabel').css('display', 'none');
        $('#therapy').css('display', 'none');
        $('#diagnose').css('display', 'inline');
        $('#therapylabel').css('display', 'none');
        $('#diagnoselabel').css('display', 'inline-block');
        $('#prescription').css('display', 'none');
        $('#examinations').css('display', 'inline-block');
        $('#prescriptionlabel').css('display', 'none');
        $('#examinationslabel').css('display', 'inline-block');
        $('#submitdiagnose').css('display', 'none');
        $('#submitexams').css('display', 'inline-block');


    });
}