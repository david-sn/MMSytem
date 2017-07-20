<%-- 
    Document   : MemberDetails
    Created on : Jul 14, 2017, 2:08:33 PM
    Author     : David Shire
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <!--Table load All--> 
        <table class="table table-bordered table-hover table-responsive" align='center' cellspacing=2 cellpadding=5 id="data_table" border=1>
            <tr class="info">
                <th onclick="sortTable(1)" class="text-center">Name <span class="glyphicon glyphicon-sort" aria-hidden="true"></span> </th>
                <th onclick="sortTable(2)" class="text-center">Country <span class="glyphicon glyphicon-sort" aria-hidden="true"></span> </th>
                <th onclick="sortTable(3)" class="text-center">Age <span class="glyphicon glyphicon-sort" aria-hidden="true"></span> </th>
                <th onclick="sortTable(4)" class="text-center">Action</th>
            </tr>
            <tr align='center' class="search-table success">
                <td><input type="text" id="new_name"></td>
                <td><input type="text" id="new_country"></td>
                <td><input type="text" id="new_age"></td>
                <td>
                    <button  class="search btn_control_option_table" style="border-radius: 2px; background-color: inherit; color: rgba(28, 149, 207, 0.6);" onclick="search();" ><span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span> </button>
                </td>
            </tr>

            <c:forEach items="${k}" var="U">
                <tr id="row${U.phone}">
                    <td id="name_row${U.phone}">${U.name}</td>
                    <td id="country_row${U.phone}">${U.dob}</td>
                    <td id="age_row${U.phone}">${U.phone}</td>
                    <td align='center'>
                        <button id="edit_button${U.phone}"   onclick="edit_row('${U.phone}')" style ="color: brown"  class="edit btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Edit Record" >             <span class="glyphicon glyphicon-edit" aria-hidden="true">           </span></button>
                        <button id="save_button${U.phone}"  onclick="save_row('${U.phone}')" style="color: darkseagreen" class="save hidden btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Save Changes"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true">      </span></button>
                        <button id="delete_button${U.phone}" onclick="delete_row('${U.phone}')" style="color:red"     class="btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Delete Record">                 <span class="glyphicon glyphicon-remove-circle" aria-hidden="true">  </span></button>
                        <button id="cancel_button${U.phone}" onclick="cancel_chage('${U.phone}')" style="color:blue"    class="hidden btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Cancel Changes">         <span class="glyphicon glyphicon-ban-circle" aria-hidden="true">     </span></button>
                    </td>
                </tr>
            </c:forEach>


            <!--add new Record-->
            <tr align='center' class="search-table">
                <td><input type="text" id="newRecord_name"></td>
                <td><input type="text" id="newRecord_country"></td>
                <td><input type="text" id="newRecord_age"></td>
                <td>
                    <button  class="add btn_control_option_table" style="border-radius: 2px; background-color: yellowgreen;" onclick="add_row();" ><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> </button>
                </td>
            </tr>
        </table>


        <!--Pagination-->
        <div style=" display: inline-block; float: left;
             justify-content: center;">

            <nav aria-label="Page navigation">
                <ul class="pagination pagination-sm">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <!--drop down number list-->
        <div style=" display: inline-block; float: left;
             justify-content: center; top: 10px;">
            <div class="dropdown" style="padding-top: 18px;">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Dropdown
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">6</a></li>
                    <li><a href="#">7</a></li>
                    <li><a href="#">8</a></li>
                </ul>
            </div>  
        </div>

        <script>
            //                for btn action

            function controlChanges(no) {
                $(("#save_button" + no)).toggleClass("hidden");
                $(("#cancel_button" + no)).toggleClass("hidden");
                $(("#edit_button" + no)).toggleClass("hidden");
                $(("#delete_button" + no)).toggleClass("hidden");
            }

            var name_data, country_data, age_data;

            function edit_row(no) {

                var name = document.getElementById("name_row" + no);
                var country = document.getElementById("country_row" + no);
                var age = document.getElementById("age_row" + no);

                name_data = name.innerHTML;
                country_data = country.innerHTML;
                age_data = age.innerHTML;

                name.innerHTML = "<input type='text' id='name_text" + no + "' value='" + name_data + "'>";
                country.innerHTML = "<input type='text' id='country_text" + no + "' value='" + country_data + "'>";
                age.innerHTML = "<input type='text' id='age_text" + no + "' value='" + age_data + "'>";
                controlChanges(no);
            }

            function save_row(no) {
                var name_val = document.getElementById("name_text" + no).value;
                var country_val = document.getElementById("country_text" + no).value;
                var age_val = document.getElementById("age_text" + no).value;

                document.getElementById("name_row" + no).innerHTML = name_val;
                document.getElementById("country_row" + no).innerHTML = country_val;
                document.getElementById("age_row" + no).innerHTML = age_val;
                controlChanges(no);

            }

            function delete_row(no) {
                if (window.confirm("Are You Sure To Delete This Record (" + no + ")")) {
                    document.getElementById("row" + no).outerHTML = "";
                }
            }

            function add_row() {
                var new_name = $("#newRecord_name").val();
                var new_country = $("#newRecord_country").val();
                var new_age = $("#newRecord_age").val();

                var table = document.getElementById("data_table");
                var table_len = (table.rows.length) - 1;
                var row = table.insertRow(table_len).outerHTML = "<tr id='row" + table_len + "'>" +
                        "<td id='name_row" + table_len + "'>" + new_name + "</td>" +
                        "<td id='country_row" + table_len + "'>" + new_country + "</td>" +
                        "<td id='age_row" + table_len + "'>" + new_age + "</td>" +
                        "<td align='center'>" +
                        "<button id='edit_button" + table_len + "'  onclick='edit_row(" + table_len + ")' style ='color: brown' class='edit btn_control_option_table' data-toggle='tooltip' data-placement='top' title='Edit Record'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></button>" +
                        "<button id='save_button" + table_len + "'  onclick='save_row(" + table_len + ")' style='color: darkseagreen' class='save hidden btn_control_option_table' data-toggle='tooltip' data-placement='top' title='Save Changes'><span class='glyphicon glyphicon-ok-circle' aria-hidden='true'></span></button>" +
                        "<button id='delete_button" + table_len + "' onclick='delete_row(" + table_len + ")' style='color:red' class='btn_control_option_table' data-toggle='tooltip' data-placement='top' title='Delete Record' ><span class='glyphicon glyphicon-remove-circle' aria-hidden='true'></span></button>" +
                        "<button id='cancel_button" + table_len + "' onclick='cancel_chage(" + table_len + ")' style='color:blue' class='hidden btn_control_option_table' data-toggle='tooltip' data-placement='top' title='Cancel Changes'><span class='glyphicon glyphicon-ban-circle' aria-hidden='true'></span></button>" +
                        "</td></tr>";

                document.getElementById("newRecord_name").value = "";
                document.getElementById("newRecord_country").value = "";
                document.getElementById("newRecord_age").value = "";
            }

            function cancel_chage(no) {
                document.getElementById("name_row" + no).innerHTML = name_data;
                document.getElementById("country_row" + no).innerHTML = country_data;
                document.getElementById("age_row" + no).innerHTML = age_data;
                controlChanges(no);

            }
        </script>



        <style> 
            /*for action btn*/
            .btn_control_option_table{
                background-color: transparent;
                border-style: none;
            }
            #data_table .glyphicon {
                font-size: 25px;
            }
            #data_table tr td{
                font-size: 20px;
                text-height: auto;
            }
            #data_table tr:nth-child(even) {
                background-color: rgba(223, 215, 82, 0.2);
            }
            #data_table tr:nth-last-of-type {
                background-color: rgb(225, 255, 55);
            }
            .search-table{
                opacity: .2;
                transition: ease-in-out .5s all;
            }
            .search-table:hover{
                opacity: 1;
            }
            #data_table tr th:hover{
                cursor: pointer;
            }
            #data_table tr th .glyphicon {
                font-size: 15px;
                color: turquoise
            }

        </style>



        <script>
            function sortTable(n) {
                var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
                table = document.getElementById("data_table");
                switching = true;
                //Set the sorting direction to ascending:
                dir = "asc";
                /*Make a loop that will continue until
                 no switching has been done:*/
                while (switching) {
                    //start by saying: no switching is done:
                    switching = false;
                    rows = table.getElementsByTagName("TR");
                    /*Loop through all table rows (except the
                     first, which contains table headers):*/
                    for (i = 2; i < (rows.length - 2); i++) {
                        //start by saying there should be no switching:
                        shouldSwitch = false;
                        /*Get the two elements you want to compare,
                         one from current row and one from the next:*/
                        x = rows[i].getElementsByTagName("TD")[n];
                        y = rows[i + 1].getElementsByTagName("TD")[n];
                        /*check if the two rows should switch place,
                         based on the direction, asc or desc:*/
                        if (dir == "asc") {
                            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                                //if so, mark as a switch and break the loop:
                                shouldSwitch = true;
                                break;
                            }
                        } else if (dir == "desc") {
                            if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                                //if so, mark as a switch and break the loop:
                                shouldSwitch = true;
                                break;
                            }
                        }
                    }
                    if (shouldSwitch) {
                        /*If a switch has been marked, make the switch
                         and mark that a switch has been done:*/
                        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                        switching = true;
                        //Each time a switch is done, increase this count by 1:
                        switchcount++;
                    } else {
                        /*If no switching has been done AND the direction is "asc",
                         set the direction to "desc" and run the while loop again.*/
                        if (switchcount == 0 && dir == "asc") {
                            dir = "desc";
                            switching = true;
                        }
                    }
                }
            }
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>
