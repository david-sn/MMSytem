<%-- 
    Document   : body2
    Created on : Jul 14, 2017, 12:09:10 AM
    Author     : David Shire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <script type="text/javascript">

            $(document).ready(function () {

                $('#submitForm').submit(function (e) {
                    var frm = $('#submitForm');
                    e.preventDefault();

                    var data = {};
                    var Form = this;

                    //Gather Data also remove undefined keys(buttons)
                    $.each(this, function (i, v) {
                        var input = $(v);
                        data[input.attr("name")] = input.val();
                        delete data["undefined"];
                    });
                    $.ajax({
                        contentType: 'application/json; charset=utf-8',
                        type: frm.attr('method'),
                        url: frm.attr('action'),
                        dataType: 'json',
                        data: JSON.stringify(data),
                        success: function (callback) {
                            alert("Response: Name: " + callback.name + "  DOB: " + callback.dob + "  Email: " + callback.email + "  Phone: " + callback.phone);
                            $(this).html("Success!");
                        },
                        error: function () {
                            $(this).html("Error!");
                        }
                    });
                });
            });
        </script>

        <form  action="submitForm.web" method="post" id="submitForm">     

            <fieldset style="width: 300px;">
                <legend>User details</legend>
                <ol>
                    <li>
                        <p><label for=name>Name</label>
                            <input name="name"  type="text" placeholder="First and last name" /></p>
                    </li>
                    <li>
                        <label for=name>Date</label>
                        <input name="dob" type="date" required="false" />
                    </li>
                    <li>
                        <p><label for=email>Email</label>
                            <input name="email" type="text" required="true" /></p>
                    </li>
                    <li>
                        <p><label for=phone>Phone</label>
                            <input name="phone" type="text" required="true" /></p>
                    </li>
                </ol>
            </fieldset>

            <fieldset style="width: 300px;">
                <input id="submitId" type="submit" value="Submit Form">
            </fieldset>
        </form> 		

    </tiles:putAttribute>
</tiles:insertDefinition>
