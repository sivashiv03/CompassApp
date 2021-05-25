$(document).ready(function () {
    var customerId;
    if (localStorage["customerId"] !== "null" && localStorage["customerId"] !== "") {
        customerId = localStorage["customerId"];
        localStorage["customerId"] = null;
        getAjaxReq('/getCustomer/'+customerId).done(handleCustomerResponse);
    }

     function getAjaxReq(url) {
        return $.ajax({
            url: url,
            type: "GET",
            contentType: "application/json",
            data: "",
            dataType: "json",
            cache: false,
            timeout: 600000
        });
    }

    function handleCustomerResponse(data){
        $.each(data, function(key, val) {
            $('#'+key).val(val).attr('disabled','disabled');
        });    
        $("#step1Submit").click();
        $("#step2Submit").click();

    };

    $('[data-toggle="offcanvas"]').click(function () {
        $("#navigation").toggleClass("hidden-xs");
    });

    //Clear up Form with pre-filled values (for type long and double from backend)
    var setupPanelBody = $("div.setup-content");
    var numberFieldsPanelBody = setupPanelBody.find("input[type='text']");
    for (var i = 0; i < numberFieldsPanelBody.length; i++) {
        $("#" + numberFieldsPanelBody[i].id).val("");
    }

    //Validation for Input Type Number
    (function ($) {
        $.fn.inputFilter = function (inputFilter) {
            return this.on("input keydown keyup mousedown mouseup select contextmenu drop", function () {
                if (inputFilter(this.value)) {
                    this.oldValue = this.value;
                    this.oldSelectionStart = this.selectionStart;
                    this.oldSelectionEnd = this.selectionEnd;
                } else if (this.hasOwnProperty("oldValue")) {
                    this.value = this.oldValue;
                    this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
                } else {
                    this.value = "";
                }
            });
        };
    })(jQuery);

    $(".textNumber").inputFilter(function (value) {
        return /^[a-zA-Z0-9_]*$/.test(value);
    });

    $(".number").inputFilter(function (value) {
        return /^-?\d*[.,]?\d{0,3}$/.test(value);
    });

    $(".onlyNumber").inputFilter(function (value) {
        return /^-?\d*$/.test(value);
    });

    var navListItems = $("div.setup-panel div a"),
        allWells = $(".setup-content"),
        allNextBtn = $(".nextBtn");

    allWells.hide();

    navListItems.click(function (e) {
        e.preventDefault();
        var $target = $($(this).attr("href")),
            $item = $(this);

        if (!$item.hasClass("disabled")) {
            navListItems.removeClass("btn-primary").addClass("btn-default");
            $item.addClass("btn-primary");
            allWells.hide();
            $target.show();
            $target.find("input:eq(0)").focus();
        }
    });

    allNextBtn.click(function () {
        var curStep = $(this).closest(".setup-content"),
            curStepBtn = curStep.attr("id"),
            nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]')
                .parent()
                .next()
                .children("a"),
            curInputs = curStep.find("input[type='text'],input[type='url']"),
            isValid = true;

        $(".form-group").removeClass("has-error");
        for (var i = 0; i < curInputs.length; i++) {
            if (!curInputs[i].validity.valid) {
                isValid = false;
                $(curInputs[i]).closest(".form-group").addClass("has-error");
            }
        }

        if (isValid) nextStepWizard.removeAttr("disabled").trigger("click");
    });

    $("div.setup-panel div a.btn-primary").trigger("click");

    $("#step2Submit").click(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        //Do not send data for save during edit mode
        if(typeof customerId === "undefined"){
            ajax_post();
        }
    });

    function ajax_post() {
        var search = JSON.stringify($("form").serializeObject());

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/addCustomerAjax",
            data: search,
            dataType: "json",
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data);
                var resultMsg;
                if (data.errorCode == 200) {
                    resultMsg = "Customer/Company Details Saved Successfully";
                } else {
                    resultMsg = "Failed To Save Customer";
                }
                // $('#step-3').append("<div class='col-xs-12'><div class='col-md-12'><h3>" + resultMsg + "</h3></div></div>");
                // $(".setup-panel").find('.btn-circle').attr('disabled', 'disabled');
            },
            error: function (e) {
                console.log("ERROR : ", e);
            },
        });
    }

    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || "");
            } else {
                o[this.name] = this.value || "";
            }
        });
        return o;
    };

    $("#assementScopeWindow :checkbox").change(function (event) {
        var streamName = event.target.name;
        // this will contain a reference to the checkbox
        if (this.checked) {
            // the checkbox is now checked
            console.log("Checked");
            $.ajax({
                type: "GET",
                contentType: "application/json",
                url: "/getProcessByStream/" + streamName,
                data: "",
                dataType: "json",
                cache: false,
                timeout: 600000,
                success: function (data) {
                    console.log("SUCCESS : ", data);
                    if (data.errorCode == 200) {
                        $("#assementScopeWindow").append("<div class='" + streamName + " animated slideInDown'></div>");
                        $.each(data.resultBody, function (key, value) {
                            console.log(key + ": " + value);
                            $("." + streamName).append(
                                "<br/><div class='row '" +
                                    value.streamCode +
                                    "'><input type='checkbox' id='" +
                                    value.streamCode +
                                    key +
                                    "' name='" +
                                    value.streamCode +
                                    key +
                                    "'> <label class='control-label' for='" +
                                    value.streamCode +
                                    "'>" +
                                    value.processName +
                                    " </label></div><br/>"
                            );
                        });
                    }
                    // $('#step-3').append("<div class='col-xs-12'><div class='col-md-12'><h3>" + resultMsg + "</h3></div></div>");
                    // $(".setup-panel").find('.btn-circle').attr('disabled', 'disabled');
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                },
            });
        } else {
            // the checkbox is now no longer checked
            console.log("Un-Checked");
            $("." + streamName)
                .slideUp()
                .remove();
        }
    });
});
