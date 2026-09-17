/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 100.0, "KoPercent": 0.0};
    var dataset = [
        {
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.7035555555555556, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.8966666666666666, 500, 1500, "Flight-HTTP Request-0"], "isController": false}, {"data": [1.0, 500, 1500, "Holidays-HTTP Request-0"], "isController": false}, {"data": [0.3233333333333333, 500, 1500, "Holidays-HTTP Request-1"], "isController": false}, {"data": [0.8133333333333334, 500, 1500, "Cabs-HTTP Request-1"], "isController": false}, {"data": [1.0, 500, 1500, "Cabs-HTTP Request-0"], "isController": false}, {"data": [0.5833333333333334, 500, 1500, "Homestays-HTTP Request-1"], "isController": false}, {"data": [1.0, 500, 1500, "Homestays-HTTP Request-0"], "isController": false}, {"data": [0.24333333333333335, 500, 1500, "Flight-HTTP Request"], "isController": false}, {"data": [0.8666666666666667, 500, 1500, "Railways-HTTP Request"], "isController": false}, {"data": [0.2866666666666667, 500, 1500, "Flight-HTTP Request-1"], "isController": false}, {"data": [0.56, 500, 1500, "Homestays-HTTP Request"], "isController": false}, {"data": [0.3, 500, 1500, "Holidays-HTTP Request"], "isController": false}, {"data": [0.8133333333333334, 500, 1500, "Cabs-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Railways-HTTP Request-0"], "isController": false}, {"data": [0.8666666666666667, 500, 1500, "Railways-HTTP Request-1"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 2250, 0, 0.0, 1050.0408888888871, 17, 17281, 258.0, 2737.8, 4846.799999999996, 10386.469999999628, 62.581703891191275, 11128.343775206518, 10.707338400133507], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["Flight-HTTP Request-0", 150, 0, 0.0, 205.22000000000006, 17, 1158, 21.0, 813.9000000000002, 896.0, 1148.3100000000002, 4.660266567247646, 1.98880516590549, 0.5734312377668003], "isController": false}, {"data": ["Holidays-HTTP Request-0", 150, 0, 0.0, 22.09333333333333, 18, 231, 20.0, 23.0, 25.44999999999999, 129.00000000000182, 4.7120912260861365, 2.043133305060786, 0.6120196612006409], "isController": false}, {"data": ["Holidays-HTTP Request-1", 150, 0, 0.0, 2303.6599999999994, 424, 16577, 1358.5, 5788.400000000001, 8425.249999999998, 14471.210000000037, 4.518208379770475, 1293.895188625787, 0.6221361147926143], "isController": false}, {"data": ["Cabs-HTTP Request-1", 150, 0, 0.0, 1027.306666666666, 113, 17258, 177.0, 2538.7000000000016, 4874.899999999996, 17253.92, 4.589963280293758, 825.7241742847307, 0.5871925680844553], "isController": false}, {"data": ["Cabs-HTTP Request-0", 150, 0, 0.0, 20.493333333333332, 18, 32, 20.0, 22.0, 24.44999999999999, 30.470000000000027, 4.608436511106333, 1.9531850056837383, 0.5535524324864051], "isController": false}, {"data": ["Homestays-HTTP Request-1", 150, 0, 0.0, 1279.6399999999999, 201, 16754, 687.5, 3238.1000000000013, 4662.699999999994, 12583.220000000074, 4.563292872136534, 1388.6852737310242, 0.6060623345806333], "isController": false}, {"data": ["Homestays-HTTP Request-0", 150, 0, 0.0, 20.80666666666666, 18, 38, 20.0, 22.900000000000006, 23.44999999999999, 35.960000000000036, 4.6575172328137615, 1.9967285793019933, 0.5821896541017201], "isController": false}, {"data": ["Flight-HTTP Request", 150, 0, 0.0, 2503.646666666669, 422, 17195, 1609.5, 5436.200000000001, 7970.249999999987, 16726.820000000007, 4.480286738351254, 1683.8202144937277, 1.1375728046594984], "isController": false}, {"data": ["Railways-HTTP Request", 150, 0, 0.0, 698.1999999999996, 141, 15810, 203.0, 1273.3, 3415.6999999999703, 12421.56000000006, 4.588418830870882, 853.2404991052582, 1.1739899743048545], "isController": false}, {"data": ["Flight-HTTP Request-1", 150, 0, 0.0, 2297.0000000000005, 401, 17175, 1512.5, 5141.000000000004, 7947.349999999988, 16707.33000000001, 4.603768952182187, 1728.2636765507027, 0.6024463277269658], "isController": false}, {"data": ["Homestays-HTTP Request", 150, 0, 0.0, 1300.5466666666666, 221, 16774, 707.0, 3259.9000000000015, 4682.599999999994, 12603.730000000074, 4.55857772375019, 1389.2046884497036, 1.1752583194043458], "isController": false}, {"data": ["Holidays-HTTP Request", 150, 0, 0.0, 2325.9000000000015, 445, 16598, 1379.0, 5807.400000000001, 8449.099999999999, 14491.700000000037, 4.515488124266233, 1295.0740669402298, 1.2082458457509255], "isController": false}, {"data": ["Cabs-HTTP Request", 150, 0, 0.0, 1048.0066666666664, 132, 17281, 197.0, 2558.7000000000016, 4895.899999999996, 17275.39, 4.587015687593652, 827.1380151791994, 1.1377949068835815], "isController": false}, {"data": ["Railways-HTTP Request-0", 150, 0, 0.0, 20.46, 18, 26, 20.0, 22.0, 24.0, 26.0, 4.610277846078191, 1.971974313068601, 0.571782506300713], "isController": false}, {"data": ["Railways-HTTP Request-1", 150, 0, 0.0, 677.6333333333333, 121, 15786, 181.5, 1253.2, 3394.4499999999703, 12399.09000000006, 4.591227694285452, 851.7989960515442, 0.605288807352086], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": []}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 2250, 0, "", "", "", "", "", "", "", "", "", ""], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
