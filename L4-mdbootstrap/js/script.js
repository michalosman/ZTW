function load(){
    
    var ctx = document.getElementById("chart-line");
    var myLineChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
        labels: ["Travel 1", "Travel 2", "Travel 3", "Travel 4"],
            datasets: [{
                data: [1200, 1700, 800, 200],
                backgroundColor: ["#38b076", "#b03872", "#38aeb0", "#7638b0"],
                borderWidth:0
            }]
        },
        options: {
            title: {
                display: false,
                text: 'Weather'
            },
            legend:{
                display: false
            },
            tooltip:{
                bodyFont: {
                    size: 50
                }
            }
        }
    });

}
