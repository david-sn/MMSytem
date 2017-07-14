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

        <style>
            button.accordion {
                background-color: #eee;
                color: #444;
                cursor: pointer;
                padding: 18px;
                width: 100%;
                border: none;
                text-align: left;
                outline: none;
                font-size: 15px;
                transition: 0.4s;
            }

            button.accordion.active, button.accordion:hover {
                background-color: #ddd;
            }

            button.accordion:after {
                content: '\002B';
                color: #777;
                font-weight: bold;
                float: right;
                margin-left: 5px;
            }

            button.accordion.active:after {
                content: "\2212";
            }

            div.panel {
                padding: 0 18px;
                background-color: white;
                max-height: 0;
                overflow: hidden;
                transition: max-height 0.2s ease-out;
            }
        </style>
        <script>
            var acc = document.getElementsByClassName("accordion");
            var i;

            for (i = 0; i < acc.length; i++) {
                acc[i].onclick = function () {
                    this.classList.toggle("active");
                    var panel = this.nextElementSibling;
                    if (panel.style.maxHeight) {
                        panel.style.maxHeight = null;
                    } else {
                        panel.style.maxHeight = panel.scrollHeight + "px";
                    }
                };
            }
        </script>


        <h2>Accordion with symbols</h2>
        <p>In this example we have added a "plus" sign to each button. When the user clicks on the button, the "plus" sign is replaced with a "minus" sign.</p>


        <!--Table load All--> 
        <table class="table table-striped table-bordered table-hover table-responsive" align='center' cellspacing=2 cellpadding=5 id="data_table" border=1>
            <tr class="info">
                <th>Name</th>
                <th>Country</th>
                <th>Age</th>
                <th>Option</th>
            </tr>

            <tr id="row1">
                <td id="name_row1">Ankit</td>
                <td id="country_row1">India</td>
                <td id="age_row1">20</td>
                <td> 
                    <button id="edit_btn"   style="color: brown"  class="edit btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Edit Record" >             <span class="glyphicon glyphicon-edit" aria-hidden="true">           </span></button>
                    <button id="save_btn"   style="color: darkseagreen" class="save hidden btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Save Changes"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true">      </span></button>
                    <button id="cancel_btn" style="color:blue"    class="hidden btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Cancel Changes">         <span class="glyphicon glyphicon-ban-circle" aria-hidden="true">     </span></button>
                    <button id="delete_btn" style="color:red"     class="btn_control_option_table" data-toggle="tooltip" data-placement="top" title="Delete Record">                 <span class="glyphicon glyphicon-remove-circle" aria-hidden="true">  </span></button>
                </td>
            </tr>

            <script>
                $("#save_btn, #cancel_btn, #edit_btn").click(function () {
                    $("#save_btn").toggleClass("hidden");
                    $("#cancel_btn").toggleClass("hidden");
                    $("#edit_btn").toggleClass("hidden");
                    $("#delete_btn").toggleClass("hidden");
                });

                $("#delete_btn").click(function () {
                    if (confirm("Do You Want To Delete This Record")) {
                        DeleteRecord();
                    }
                });

                function DeleteRecord() {

                }

                function InsertRecord() {

                }

                function UpdateRecord() {

                }

                function CancelChanges() {

                }

            </script>
            <style> 
                .btn_control_option_table{
                    background-color: transparent;
                    border-style: none;
                }
                .glyphicon {
                    font-size: 25px;
                }
            </style>





            <tr>
                <td><input type="text" id="new_name"></td>
                <td><input type="text" id="new_country"></td>
                <td><input type="text" id="new_age"></td>
                <td><button  class="add btn_control_option_table" style="border-radius: 2px; background-color: yellowgreen;" onclick="add_row();" ><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> </button></td>
            </tr>

        </table>
















        <button class="accordion">Section 1</button>
        <div class="panel">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>

        <button class="accordion">Section 2</button>
        <div class="panel">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>

        <button class="accordion">Section 3</button>
        <div class="panel">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>





    </tiles:putAttribute>
</tiles:insertDefinition>
