<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script>
    function changeLevel(packageName) {
        $.ajax({
            url: "/loggers/" + packageName,
            type: "post",
            data: {
                configuredLevel: $('#' + packageName + "_id" + ' option:selected').val()
            },
            contentType: "application/json",
            success: function(data) {
                alert(data);
            }
        })
    }

    $(document).ready(function() {
        function renderLoggers(logInfo) {
            var levels = logInfo.levels;
            var loggers = logInfo.loggers;
            var selectTemplateHtm = "<select id='$packageName$_id'>";
            for (var i = 0; i < levels.length; i++) {
                var levelName = levels[i];
                selectTemplateHtm += "<option value='" + levelName + "'>" + levelName + "</option>"
            }
            selectTemplateHtm += "</select>";
            var tbodyHtm = "";
            for (var pkgName in loggers) {
                tbodyHtm += "<tr>" +
                        "<td>" +
                            pkgName +
                        "</td>" +
                        "<td>" +
                            loggers[pkgName].configuredLevel +
                        "</td>" +
                        "<td>" +
                            loggers[pkgName].effectiveLevel +
                        "</td>" +
                        "<td>" +
                            selectTemplateHtm.replace(/\$packageName\$/g, pkgName) +
                            "<input type='button' value='change' onclick='changeLevel(\"" + pkgName + "\")'>"
                        "</td>" +
                    "</tr>";
            }
            $("#logger_tbody").html(tbodyHtm);
        }

        $.ajax({
            url: "/loggers.json",
            type: "get",
            dataType: "json",
            success: function(logInfo) {
                renderLoggers(logInfo);
            }
        })
    })
</script>

<table border="1" width="100%">
    <thead>
        <tr>
            <th width="50%">
                Package
            </th>
            <th width="20%">
                Configured Level
            </th>
            <th width="20%">
                Effective Level
            </th>
            <th>
               Actions
            </th>
        </tr>
    </thead>
    <tbody id="logger_tbody">
    </tbody>
</table>
