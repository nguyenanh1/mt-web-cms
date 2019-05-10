// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

$(document).ready(function () {
    var labelGet = new Array();
    var datagGet;
    var now = new Date();
    var max = new Date(now.getTime() - (12 * 24 * 60 * 60 * 1000));
    $.ajax({
        url: 'home/report',
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        data: {
            start: max.getTime(),
            from: now.getTime()
        },
        success: function (data) {
            for (var i = 0; i < data.labels.length; i++) {
                labelGet.push(data.labels[i].label);
            }
            var ctx = document.getElementById("myAreaChart");
            var myLineChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: labelGet,
                    datasets: [{
                            label: "Sessions",
                            lineTension: 0.3,
                            backgroundColor: "rgba(2,117,216,0.2)",
                            borderColor: "rgba(2,117,216,1)",
                            pointRadius: 5,
                            pointBackgroundColor: "rgba(2,117,216,1)",
                            pointBorderColor: "rgba(255,255,255,0.8)",
                            pointHoverRadius: 5,
                            pointHoverBackgroundColor: "rgba(2,117,216,1)",
                            pointHitRadius: 50,
                            pointBorderWidth: 2,
                            data: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
                        }]
                },
                options: {
                    scales: {
                        xAxes: [{
                                time: {
                                    unit: 'date'
                                },
                                gridLines: {
                                    display: false
                                },
                                ticks: {
                                    maxTicksLimit: 7
                                }
                            }]
                    },
                    legend: {
                        display: false
                    }
                }
            });
        },
        error: function ()
        {
            alert("error");
        }
    });
    console.log(labelGet);

});


// Area Chart Example


