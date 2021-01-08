let question;
function signInClicked() {
    $('#content_page').load('signin.html');
}

window.addEventListener('load', (event) => {
    $('#content_page').load('signin.html');

});
function logOutClicked() {
    $('#replace').empty();
    $('#logout').css('display', 'none');
    $('#addPatient').css('display', 'none');
    $('#searchPatient').css('display', 'none');
    $('#signin').css('display', 'inline');
    $('#seePatients').css('display', 'none');
    $('#addShift').css('display', 'none');
    $('#seeShift').css('display', 'none');
    $('#content_page').load('signin.html');
}

function addPatientInfoClicked() {
    $('#content_page').load('patientinfo.html', function () {
        $('#illnessphlabel').css('display', 'none');
        $('#namephlabel').css('display', 'none');
        $('#typephlabel').css('display', 'none');
        $('#dosephlabel').css('display', 'none');
        $('#nameph').css('display', 'none');
        $('#typeph').css('display', 'none');
        $('#doseph').css('display', 'none');
        $('#illnessph').css('display', 'none');


        $('#report').css('display', 'none');
        $('#reportlabel').css('display', 'none');
        $('#doctor').css('display', 'none');
        $('#doctorlabel').css('display', 'none');
        $('#therapy').css('display', 'none');
        $('#diagnose').css('display', 'none');
        $('#therapylabel').css('display', 'none');
        $('#diagnoselabel').css('display', 'none');
        $('#prescription').css('display', 'none');
        $('#examinations').css('display', 'none');
        $('#prescriptionlabel').css('display', 'none');
        $('#examinationslabel').css('display', 'none');
        $('#submitdiagnose').css('display', 'none');
        $('#submitexam').css('display', 'none');
    });
}

function addShiftClicked() {
    $('#replace').empty();

    $('#content_page').load('addShift.html');
}

function sqlClicked() {
    $('#replace').empty();
    $('#content_page').load('questions.html');
}


function seePatientsClicked() {
    $('#content_page').load('patientinfo.html', function () {
        getPatient();
        $('#address').css('display', 'none');
        $('#addresslabel').css('display', 'none');
        $('#doctor').css('display', 'none');
        $('#doctorlabel').css('display', 'none');
        $('#submitdiagnose').css('display', 'inline');
        $('#submitexam').css('display', 'none');
        $('#submitpatient').css('display', 'none');

    });
}
function seeShiftClicked() {
    getShift();
}

function searchPatientInfoClicked() {
    $('#content_page').load('searchAmka.html');
    getPatientsForExams();
}

$('#searchPatient').css('display', 'none');
$('#seePatients').css('display', 'none');
$('#addPatient').css('display', 'none');
$('#addShift').css('display', 'none');
$('#seeShift').css('display', 'none');
$('#logout').css('display', 'none');


$(document).on('DOMNodeInserted', function (e) {
    if ($(e.target).hasClass('container')) {
        $('#signinbtn').on('click', getUsers);
    }
});

$(document).on('DOMNodeInserted', function (e) {
    if ($(e.target).hasClass('shift-container')) {
        $('#submitshift').on('click', addShift);
    }
});


$(document).on('DOMNodeInserted', function (e) {
    if ($(e.target).hasClass('addpatient')) {
        $('#submitpatient').on('click', addPatient);
        $('#submitdiagnose').on('click', addDiagnose);
        $('#submitexam').on('click', addReport);

    }
});

$(document).on('DOMNodeInserted', function (e) {
    if ($(e.target).hasClass('searchamkadiv')) {
        $('#searchbtn').on('click', searchPatient);
    }
});

$(document).on('DOMNodeInserted', function (e) {
    if ($(e.target).hasClass('replaceshift-container')) {
        $('#submitreplace').on('click', replaceShift);
    }
});

function visits() {
    question = "visits";
    document.getElementById('question').value = "SELECT p.full_name , p.amka, p.doctor, e.diagnose , e.prescription, e.therapy FROM patients p INNER JOIN examinations e ON p.amka=e.amka WHERE date='07/01/2021';";

}
function covid() {
    question = "covid";
    document.getElementById('question').value = "SELECT p.full_name,p.amka, p.diseases, e.diagnose,p.address, p.insurance FROM patients p INNER JOIN examinations e ON p.amka=e.amka WHERE e.diagnose='COVID-19';";

}

$(document).on('DOMNodeInserted', function (e) {
    if ($(e.target).hasClass('questions-container')) {
        $('#viewvisits').on('click', visits);
        $('#viewcovid').on('click', covid);
//        $('#viewstats').on('click', visits);
//        $('#viewpersonshift').on('click', visits);
        $('#submitquestion').on('click', getQuestion);
    }
});