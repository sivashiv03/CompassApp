$(document).ready(function () {
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
});
