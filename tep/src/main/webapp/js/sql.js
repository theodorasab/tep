function getQuestion() {
    if (question == 'covid') {
    var data = new FormData();
    data.append('covid', $("#question").val());
    ajaxRequest('GET', 'http://localhost:8080/tep/getCOVID', data, function (o) {
        var res = JSON.parse(o.responseText);
        console.log(res);
        var covid = "<table>" +
                "<tr>" +
                "<th> Full Name </th>" +
                "<th> AMKA </th>" +
                "<th> Insurance </th>" +
                "<th> Diseases </th>" +
                "<th> Address</th>" +
                "<th> Diagnose</th>" +
                "</tr>";
        for (i = 0; i < res.length; i++) {
            covid += "<tr>" +
                    "<td>" + res[i].full_name + "</td>" +
                    "<td>" + res[i].amka + "</td>" +
                    "<td>" + res[i].insurance + "</td>" +
                    "<td>" + res[i].diseases + "</td>" +
                    "<td>" + res[i].address + "</td>" +
                    "<td>" + "COVID-19" + "</td>" +
                    "</tr>";
        }
        covid += "</table>";

            $("#display_sql").html(covid);
    });
    } else if (question == 'visits') {
        var data = new FormData();
        data.append('visits', $("#question").val());
        ajaxRequest('GET', 'http://localhost:8080/tep/getVisits', data, function (o) {
            var res = JSON.parse(o.responseText);

            console.log(res.map.exams.myArrayList);
            res0 = res.map.patients.myArrayList;
            var res1 = res.map.exams.myArrayList;
            var visits = "<table>" +
                    "<tr>" +
                    "<th> Full Name </th>" +
                    "<th> AMKA </th>" +
                    "<th> Doctor </th>" +
                    "<th> Diagnose </th>" +
                    "<th> Prescription</th>" +
                    "<th> Therapy</th>" +
                    "</tr>";
            for (i = 0; i < res0.length; i++) {

                visits += "<tr>" +
                        "<td>" + res0[i].full_name + "</td>" +
                        "<td>" + res0[i].amka + "</td>" +
                        "<td>" + res0[i].doctor + "</td>" +
                        "<td>" + res1[i].diagnose + "</td>" +
                        "<td>" + res1[i].prescription + "</td>" +
                        "<td>" + res1[i].therapy + "</td>" +
                        "</tr>";
            }
            visits += "</table>";
            $("#display_sql").html(visits);
        });
    }

}