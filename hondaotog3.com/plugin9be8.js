var $popupPriceQuote = new priceQuotePlugin('#popupBaoGia');
$popupPriceQuote.init();
function priceQuotePlugin(id) {
    var instant = this;
    this.id = id;
    this.opened = false;
    this.openedScroll = false;
    this.openedExit = false;
    this.currentTop = 0;
    this.data = {"id":"52","html":"<a id=\"popupBaoGiaLink\" href=\"javascript:void(0)\" class=\"btn-link-car\"><em class=\"fa fa-envelope-o\">&nbsp;</em><span class=\"text\">NHẬN BÁO GIÁ</span></a>\r\n<div id=\"popupBaoGia\" style=\"display:none;max-width:600px;\">\r\n    <div class=\"box-car\">\r\n        <h3 class=\"car-title\" id=\"lblCarTitle\" data-col=\"title\">YÊU CẦU BÁO GIÁ</h3>\r\n        <h4 class=\"car-desc\" id=\"lblCarDesc\" data-col=\"desc\">Để nhận được \"BÁO GIÁ ĐẶC BIỆT\" và các \"CHƯƠNG TRÌNH ƯU ĐÃI\", Quý khách vui lòng điền form báo giá dưới đây:</h4>\r\n        <div class=\"form-group\" id=\"selectLoaiXeLaiXe\">\r\n            <label><span id=\"spanModelLoaiXe\">Chọn Dòng Xe</span> <span class=\"required\">*</span></label>\r\n            <select class=\"form-control\" id=\"cboLoaiXeBaoGiaPopup\" name=\"cboLoaiXeBaoGiaPopup\" data-col=\"vehicles\" data-field=\"DongXe\" data-type=\"select\" data-required=\"1\" data-title=\"Dòng xe\"></select>\r\n        </div>\r\n        <div class=\"form-group\">\r\n            <label>Hình thức thanh toán:</label>\r\n            <label class=\"lbl-payment\"><input type=\"radio\" name=\"radHinhThucThanhToan\" checked=\"checked\" value=\"0\" data-value=\"Trả góp\" /> Trả góp</label>\r\n            <label class=\"lbl-payment\" style=\"margin-left:20px;\"><input type=\"radio\" name=\"radHinhThucThanhToan\" value=\"1\" data-value=\"Trả hết\" /> Trả hết</label>\r\n        </div>\r\n        <div class=\"row-car\">\r\n            <div class=\"col-car-6\">\r\n                <div class=\"form-group\" id=\"popupfullname\">\r\n                    <label>Họ tên <span class=\"required\">*</span></label>\r\n                    <input type=\"text\" class=\"form-control\" id=\"txtHoTenBaoGiaPopup\" placeholder=\"Họ tên (Bắt buộc)\" data-field=\"HoTen\" data-required=\"1\" data-title=\"Họ tên\" />\r\n                </div>\r\n            </div>\r\n            <div class=\"col-car-6\">\r\n                <div class=\"form-group\" id=\"popuphotline\">\r\n                    <label>Điện thoại <span class=\"required\">*</span></label>\r\n                    <input type=\"text\" class=\"form-control\" id=\"txtDienThoaiBaoGiaPopup\" placeholder=\"Điện thoại (Bắt buộc)\" data-field=\"DienThoai\" data-required=\"1\" data-title=\"Điện thoại\" />\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"form-group\" id=\"popupemail\">\r\n            <label>Email</label>\r\n            <input type=\"text\" class=\"form-control\" id=\"txtEmailBaoGiaPopup\" placeholder=\"Email...\" data-field=\"Email\" />\r\n        </div>\r\n        <div class=\"form-group\" id=\"popupaddress\">\r\n            <label>Địa chỉ</label>\r\n            <input type=\"text\" class=\"form-control\" id=\"txtDiaChiBaoGiaPopup\" name=\"txtDiaChiBaoGiaPopup\" placeholder=\"Địa chỉ...\" data-field=\"DiaChi\" />\r\n        </div>\r\n        <div class=\"form-group\">\r\n            <a href=\"javascript:void(0);\" class=\"btn btn-default\" id=\"btnModel\">GỬI YÊU CẦU NGAY</a>\r\n        </div>\r\n    </div>\r\n</div>","css":".box-car .row-car {\r\n    display: -ms-flexbox;\r\n    display: flex;\r\n    -ms-flex-wrap: wrap;\r\n        flex-wrap: wrap;\r\n    margin-right: -5px;\r\n    margin-left: -5px;\r\n}\r\n.box-car .col-car-6 {\r\n    position: relative;\r\n    width: 100%;\r\n    -ms-flex: 0 0 50%;\r\n        flex: 0 0 50%;\r\n    max-width: 50%;\r\n    padding-right: 5px;\r\n    padding-left: 5px;\r\n}\r\n.box-car .car-title {\r\n    text-align: center;\r\n    font-size: 30px;\r\n    color: #1565c0;\r\n    margin-bottom: 6px;\r\n}\r\n.box-car .car-desc {\r\n    text-align: center;\r\n    font-weight: normal;\r\n    margin-bottom: 20px;\r\n}\r\n.box-car label {\r\n    margin-top: 10px;\r\n}\r\n.box-car .lbl-payment {\r\n    margin-left: 20px;\r\n}\r\n.box-car .btn-default {\r\n    width: 100%;\r\n    margin-top: 10px;\r\n}\r\n@media (max-width: 575px) {\r\n    #popupBaoGia{\r\n        padding:10px!important;\r\n    }\r\n}","data":"{\"triggers\":{\"timer\":{\"active\":1,\"value\":20},\"scroll\":{\"active\":0,\"value\":0},\"exit\":0,\"links\":[]},\"title\":\"YÊU CẦU BÁO GIÁ HONDA\",\"desc\":\"Để nhận được \\\"BÁO GIÁ ĐẶC BIỆT\\\" và các \\\"CHƯƠNG TRÌNH ƯU ĐÃI\\\", Quý khách vui lòng điền form báo giá dưới đây:\",\"vehicles\":[\"Honda City\",\"Honda Civic\",\"Honda HR-V\",\"Honda CR-V\",\"Honda BR-V\",\"Honda Accord\"]}"};
    this.pageKeys = getPageKeys();
    this.init = function () {
        if (this.data.html && this.data.html.length > 0) {
            $('#pluginjs').after(this.data.html);
            if (this.data.css && this.data.css.length > 0) {
                $('#pluginjs').after('<style>' + this.data.css + '</style>');
            }
            var jsonData = JSON.parse(this.data.data);
            $(this.id).find('[data-col]').each(function () {
                var columnName = $(this).attr('data-col');
                switch (columnName) {
                    case "vehicles":
                        $(this).append('<option value="-1">== Chọn dòng xe ==</option>');
                        if (jsonData[columnName] && jsonData[columnName].length > 0) {
                            var vehicles = jsonData[columnName];
                            for (var i = 0; i < vehicles.length; i++) {
                                $(this).append('<option value="1">' + vehicles[i] + '</option>');
                            }
                        }
                        break;
                    default:
                        if (jsonData[columnName] && jsonData[columnName].length > 0) {
                            $(this).html(jsonData[columnName]);
                        }
                        break;
                }
            });
            $(this.id).find('a.btn-default').on('click touch', function () {
                sendPriceQuote(null, instant.id)
            });
            if (jsonData['triggers']) {
                var triggers = jsonData['triggers'];
                if (this.isAutoShow(triggers.links)) {
                    if (triggers.timer && parseInt(triggers.timer.active) == 1) {
                        setTimeout(function () {
                            instant.showPopup();
                        }, triggers.timer.value * 1000);
                    }
                    if (triggers.scroll && parseInt(triggers.scroll.active) == 1) {
                        var percentPlugin = parseInt(triggers.scroll.value);
                        $(window).scroll(function () {
                            if (!instant.openedScroll) {
                                var top = this.scrollTop || document.documentElement.scrollTop;
                                var height = this.scrollHeight || document.documentElement.scrollHeight;
                                var percent = parseInt(top * 100 / height);
                                if (percent >= percentPlugin) {
                                    instant.openedScroll = true;
                                    instant.showPopup();
                                }
                            }
                        });
                    }
                    if (parseInt(triggers.exit) == 1) {
                        $(window).on('mouseout', function (e) {
                            if (!instant.openedExit) {
                                var from = e.relatedTarget || e.toElement;
                                if (!from) {
                                    instant.openedExit = true;
                                    instant.showPopup();
                                }
                            }
                        });
                    }
                }
            }
        }
    }
    this.isAutoShow = function (pLinks) {
        var res = true;
        if (pLinks && pLinks.length > 0) {
            res = false;
            var href = $(location).attr('href');
            for (var i = 0; i < pLinks.length; i++) {
                if (res) {
                    return;
                }
                if (pLinks[i].type == this.pageKeys[window.pageKey]) {
                    res = true;
                }
                else if (pLinks[i].type == "equals") {
                    if (pLinks[i].value == href || pLinks[i].value == href.substring(0, href.indexOf('?'))) {
                        res = true;
                    }
                }
                else if (pLinks[i].type == "contains") {
                    if (href.indexOf(pLinks[i].value) > -1) {
                        res = true;
                    }
                }
            }
        }
        return res;
    }
    this.showPopup = function () {
        if (!this.opened) {
            this.opened = true;
            this.currentTop = document.documentElement.scrollTop;
            $.fancybox.open({
                src: instant.id,
                type: 'inline',
                opts: {
                    keyboard: false,
                    arrows: false,
                    clickSlide: false,
                    touch: false,
                    afterClose: function (instance, current) {
                        instant.opened = false;
                        $('html, body').animate({ scrollTop: instant.currentTop }, 10);
                    }
                }
            });
        }
    }
}
$('#popupBaoGiaLink').on('click touch', function () {
    $popupPriceQuote.showPopup();
});
