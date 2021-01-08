function getQuestion() {
    if (question == 'covid') {
        var data = new FormData();
        data.append('covid', $("#question").val());
        ajaxRequest('GET', 'http://localhost:8080/tep/getCOVID', data, function (o) {
            var res = JSON.parse(o.responseText);
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
            var res0 = res.map.patients.myArrayList;
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
    } else if (question == 'shift') {
        var data = new FormData();
        data.append('shift', $("#question").val());
        ajaxRequest('GET', 'http://localhost:8080/tep/getquestionShift', data, function (o) {
            var res = JSON.parse(o.responseText);
            console.log(res);
            var shift = "<table>" +
                    "<tr>" +
                    "<th> AT </th>" +
                    "<th> Full Name </th>" +
                    "<th> Profession </th>" +
                    "<th> Date </th>" +
                    "<th> Shift</th>" +
                    "</tr>";
            for (i = 0; i < res.length; i++) {
                shift += "<tr>" +
                        "<td>" + res[i].AT + "</td>" +
                        "<td>" + res[i].full_name + "</td>" +
                        "<td>" + res[i].profession + "</td>" +
                        "<td>" + res[i].date + "</td>" +
                        "<td>" + res[i].hours + "</td>" +
                        "</tr>";
            }
            shift += "</table>";
            $("#display_sql").html(shift);
        });
    } else if (question == 'statsbymonth') {
        var data = new FormData();
        data.append('stats', $("#question").val());
        ajaxRequest('GET', 'http://localhost:8080/tep/getStats', data, function (o) {
            var res = JSON.parse(o.responseText);
            console.log(res);
            $("#display_sql").load('statistics.html', function () {
                google.charts.load('current', {'packages': ['bar']});
                google.charts.setOnLoadCallback(drawChart);
                var shift = res.map.shift;
                var exams = res.map.exams;
                var exam_order = res.map.exam_order;
                var diagnose = res.map.diagnose;
                var drugs = res.map.drugs;
                function drawChart() {
                    var data = google.visualization.arrayToDataTable([
                        ['Day', 'Shifts', 'Visits', 'Examinations', 'Diagnose', 'Drugs'],
                        ['1', shift, exams, exam_order, diagnose, drugs]
                    ]);

                    var options = {
                        chart: {
                            title: 'Statistics Per Month',
                        }
                    };

                    var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

                    chart.draw(data, google.charts.Bar.convertOptions(options));
                }
            });
        });
    } else if (question == 'statsbyday') {
        var data = new FormData();
        data.append('stats', $("#question").val());
        ajaxRequest('GET', 'http://localhost:8080/tep/getStats', data, function (o) {
            var res = JSON.parse(o.responseText);
            console.log(res);
            $("#display_sql").load('statistics.html', function () {
                google.charts.load('current', {'packages': ['bar']});
                google.charts.setOnLoadCallback(drawChart);
                var shift = res.map.shift;
                var exams = res.map.exams;
                var exam_order = res.map.exam_order;
                var diagnose = res.map.diagnose;
                var drugs = res.map.drugs;
                function drawChart() {
                    var data = google.visualization.arrayToDataTable([
                        ['Day', 'Shifts', 'Visits', 'Examinations', 'Diagnose', 'Drugs'],
                        ['1', shift, exams, exam_order, diagnose, drugs]
                    ]);

                    var options = {
                        chart: {
                            title: 'Statistics Per Month',
                        }
                    };

                    var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

                    chart.draw(data, google.charts.Bar.convertOptions(options));
                }
            });
        });
    }
}

