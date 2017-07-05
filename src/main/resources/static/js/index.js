/**
 * Created by LL on 2017/6/7.
 */
$(function () {
    $('#container').highcharts({
        chart: {
            type: 'areaspline'
        },
        title: {
            text: '不同家庭一周水果消费情况'
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            verticalAlign: 'top',
            x: 150,
            y: 100,
            floating: true,
            borderWidth: 1,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
        },
        xAxis: {
            categories: [
                '周一',
                '周二',
                '周三',
                '周四',
                '周五',
                '周六',
                '周日'
            ],
            plotBands: [{ // visualize the weekend
                from: 4.5,
                to: 6.5,
                color: 'rgba(68, 170, 213, .2)'
            }]
        },
        yAxis: {
            title: {
                text: '水果 单位'
            }
        },
        tooltip: {
            shared: true,
            valueSuffix: ' 单位'
        },
        credits: {
            enabled: false
        },
        plotOptions: {
            areaspline: {
                fillOpacity: 0.5
            }
        },
        series: [{
            name: '小张',
            data: [3, 4, 3, 5, 4, 10, 12]
        }, {
            name: '小潘',
            data: [1, 3, 4, 3, 3, 5, 4]
        }]
    });
});


function exportPDF() {
    var highcharts = $('#container').highcharts();
    var svg = highcharts.getSVG();
    var form = $("<form>");//定义一个form表单
    form.attr("style", "display:none");
    form.attr("target", "");
    form.attr("method", "post");
    form.attr("action", "export");
    var input1 = $("<input>");
    input1.attr("type", "hidden");
    input1.attr("name", "msg");
    input1.attr("value", svg);
    $("body").append(form);//将表单放置在web中
    form.append(input1);
    form.submit();//表单提交
}
