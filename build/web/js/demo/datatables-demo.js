// Call the dataTables jQuery plugin
$(document).ready(function () {
    $('#dataTable').DataTable({
        "ordering": false,
//        "oLanguage": {
//            "sLengthMenu": "Hiển thị _MENU_ bản ghi",
//            "info": "Hiển thị từ _START_ đến _END_ trong _TOTAL_ bản ghi"
//        },
        "language": {
            "lengthMenu": "Hiển thị _MENU_ bản ghi",
            "zeroRecords": "Không có bản ghi nào",
            "info": "Hiển thị từ _START_ đến _END_ trong _TOTAL_ bản ghi",
            "infoEmpty": "",
            "search": "Tìm kiếm:"
        }
    });
});
