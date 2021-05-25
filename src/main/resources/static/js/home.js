$(document).ready(function () {
    var customerJson = [];

    var $table = $("#customerTable");
    $table.bootstrapTable({ data: customerJson });
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getAllCustomers",
        data: "",
        dataType: "json",
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("SUCCESS : ", data);
            if (data.errorCode == 200) {
                for (var i = 0; i < data.resultBody.length; i++) {
                    customerJson.push({
                        id: data.resultBody[i].customerId,
                        name: data.resultBody[i].customerName,
                        country: data.resultBody[i].countryhq,
                        state: false,
                    });
                }

                $table.bootstrapTable("load", customerJson);
                //$table.bootstrapTable('hideColumn', 'state');
            }
        },
        error: function (e) {
            console.log("ERROR : ", e);
        },
    });

    $("#customerProceed").click(function () {
        if ($table.bootstrapTable("getSelections").length === 0) {
            toastr.info("Please select a customer !");
        } else {
            localStorage["customerId"] = $table.bootstrapTable("getSelections")[0].id;
            $(location).attr("href", "/getCustomerLandingPage");
        }
    });

    $("#customerCreate").click(function () {
        $(location).attr("href", "/getCustomerLandingPage");
    });
});
