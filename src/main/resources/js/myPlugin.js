define('example/autoconvert/dacconverter', ['tinymce'], function (tinymce) {
    "use strict";

    function DacConverter() {
        function pasteHandler(uri, node, done) {
            if ((uri.host === "dep.daily.vdian.net" || uri.host === "dep.vdian.net") && node.text() === uri.source) {
                var macro_name = '';
                var params = {};
                //search
                var uriParts = uri.anchor.split('?');
                if (uriParts[0] === '/search') {
                    this.macro_name = 'search-dep'
                    this.params = { 'DEP搜索链接': uri.source }

                }
                //detail
                else if (uriParts[0].search('Detail') != -1) {
                    this.macro_name = 'dep-detail';
                    this.params = { '详情地址': uri.source }
                }
                else {
                    done();
                }
                var macroRenderRequest = {
                    contentId: Confluence.Editor.getContentId(),
                    macro: {
                        name: this.macro_name,
                        params: this.params,
                        body: "<p>&nbsp;</p>"
                    }
                };
                node[0]='';
                done(node);
                tinymce.confluence.MacroUtils.insertMacro(macroRenderRequest);

            } else {
                done();
            }
        }

        tinymce.plugins.Autoconvert.autoConvert.addHandler(pasteHandler);
       }
    return DacConverter;
});

require('confluence/module-exporter').safeRequire('example/autoconvert/dacconverter', function (DacConverter) {
    require('ajs').bind("init.rte", DacConverter);
});
