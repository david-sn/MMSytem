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
                <th class="text-center">Name</th>
                <th class="text-center">Country</th>
                <th class="text-center">Age</th>
                <th class="text-center">Action</th>
            </tr>

            <tr id="row1">
                <td id="name_row1">Ankit</td>
                <td id="country_row1">India</td>
                <td id="age_row1">20</td>
                <td>
                    <button id="edit_btn1"   onclick="edit_row('1')" style ="color: brown"  class="edit btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Edit Record" >             <span class="glyphicon glyphicon-edit" aria-hidden="true">           </span></button>
                    <button id="save_btn1"  onclick="save_row('1')" style="color: darkseagreen" class="save hidden btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Save Changes"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true">      </span></button>
                    <button id="delete_btn1" onclick="delete_row('1')" style="color:red"     class="btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Delete Record">                 <span class="glyphicon glyphicon-remove-circle" aria-hidden="true">  </span></button>
                    <button id="cancel_btn1" onclick="cancel_chage('1')" style="color:blue"    class="hidden btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Cancel Changes">         <span class="glyphicon glyphicon-ban-circle" aria-hidden="true">     </span></button>
                </td>
            </tr>

            <!--add new Record-->
            <tr>
                <td><input type="text" id="new_name"></td>
                <td><input type="text" id="new_country"></td>
                <td><input type="text" id="new_age"></td>
                <td>
                    <button  class="add btn_control_option_table" onclick="add_row();" style="border-radius: 2px; background-color: yellowgreen;" onclick="add_row();" ><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> </button>
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
            $("#save_btn1, #cancel_btn1, #edit_btn1").click(function () {
                $("#save_btn1").toggleClass("hidden");
                $("#cancel_btn1").toggleClass("hidden");
                $("#edit_btn1").toggleClass("hidden");
                $("#delete_btn1").toggleClass("hidden");
            });

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
            }

            function save_row(no) {
                var name_val = document.getElementById("name_text" + no).value;
                var country_val = document.getElementById("country_text" + no).value;
                var age_val = document.getElementById("age_text" + no).value;

                document.getElementById("name_row" + no).innerHTML = name_val;
                document.getElementById("country_row" + no).innerHTML = country_val;
                document.getElementById("age_row" + no).innerHTML = age_val;
            }

            function delete_row(no) {
                if (window.confirm("Are You Sure To Delete This Record (" + no + ")")) {
                    document.getElementById("row" + no).outerHTML = "";
                }
            }

            function add_row() {
                var new_name = document.getElementById("new_name").value;
                var new_country = document.getElementById("new_country").value;
                var new_age = document.getElementById("new_age").value;

                var table = document.getElementById("data_table");
                var table_len = (table.rows.length) - 1;
                var row = table.insertRow(table_len).outerHTML = "<tr id='row" + table_len + "'>" +
                        "<td id='name_row" + table_len + "'>" + new_name + "</td>" +
                        "<td id='country_row" + table_len + "'>" + new_country + "</td>" +
                        "<td id='age_row" + table_len + "'>" + new_age + "</td>" +
                        "<td>" +
                        "<button id='edit_button" + table_len + "'  onclick='edit_row(" + table_len + ")' style ='color: brown' class='edit btn_control_option_table' data-toggle='tooltip' data-placement='top' title='Edit Record'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></button>" +
                        "<button id='save_button" + table_len + "'  onclick='save_row(" + table_len + ")' style='color: darkseagreen' class='save hidden btn_control_option_table' data-toggle='tooltip' data-placement='top' title='Save Changes'><span class='glyphicon glyphicon-ok-circle' aria-hidden='true'></span></button>" +
                        "<button onclick='delete_row(" + table_len + ")' style='color:red' class='btn_control_option_table' data-toggle='tooltip' data-placement='top' title='Delete Record' ><span class='glyphicon glyphicon-remove-circle' aria-hidden='true'></span></button>" +
                        "<button id='cancel_btn1' style='color:blue' class='hidden btn_control_option_table' data-toggle='tooltip' data-placement='top' title='Cancel Changes'><span class='glyphicon glyphicon-ban-circle' aria-hidden='true'></span></button>" +
                        "</td></tr>";

                document.getElementById("new_name").value = "";
                document.getElementById("new_country").value = "";
                document.getElementById("new_age").value = "";
            }

            function cancel_chage(no) {
                document.getElementById("name_row" + no).innerHTML = name_data;
                document.getElementById("country_row" + no).innerHTML = country_data;
                document.getElementById("age_row" + no).innerHTML = age_data;
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
                background-color: rgba(225, 255, 55);
            }
        </style>


    </tiles:putAttribute>
</tiles:insertDefinition>
