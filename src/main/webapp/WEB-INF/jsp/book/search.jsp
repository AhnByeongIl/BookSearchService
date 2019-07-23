<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <select class="selectpicker" id="type" name="type">
        <option value="title">title</option>
        <option value="isbn">isbn</option>
        <option value="publisher">publisher</option>
        <option value="person">person</option>
    </select>
    <input type="text" id="keyword" name="keyword" placeholder="keyword" />
    <button id="searchBtn">Search</button>
    <table class="table" id="bookTable">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Title</th>
          <th scope="col">Person</th>
          <th scope="col">Publisher</th>
          <th scope="col">Isbn</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
      </tbody>
    </table>
</div>

<script>

(function (window, $, undefined) {

    var bookSearch = {
        init: function() {
            this.eventBinding();
        },
        eventBinding: function() {
            $('#searchBtn').click(function() {
                var searchKeyword = encodeURI($('#keyword').val(), 'UTF-8');
                $.get('/book/search/' + $('#type').val() + '/' + searchKeyword)
                    .done(function (data) {
                        console.log(data);
                        bookSearch.bindingTableData(data);
                    })
                    .fail(function (data, status) {
                        console.log(data, status);
                    });
            });
        },
        bindingTableData: function(data) {
            var bodyHtml;
            $.each(data.rows, function(i, ele) {
                var rowHtml = '<tr>'
                              +'  <th scope="row">'+(i+1)+'</th>'
                              +'  <td>'+ele.title+'</td>'
                              +'  <td>'+ele.authors+'</td>'
                              +'  <td>'+ele.publisher+'</td>'
                              +'  <td>'+ele.isbn+'</td>'
                              +'</tr>';
                bodyHtml += rowHtml;
            });
            $('#bookTable tbody').html('');
            $('#bookTable tbody').append(bodyHtml);
        }
    };

    $(document).ready(function () {
        bookSearch.init();
    });

})(window, jQuery);

</script>