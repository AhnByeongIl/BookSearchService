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
    <input type="hidden" id="searchedType" name="searchedType" />
    <input type="hidden" id="searchedKeyword" name="searchedKeyword" />
    <button id="searchBtn">Search</button>
    <div class="table-box">
        Total: <span id="total" name="total"></span>
        <select class="selectpicker" id="records" name="records">
            <option value="10">10</option>
            <option value="30">30</option>
            <option value="50">50</option>
        </select>
        <table class="table" id="bookTable">
          <thead>
            <tr>
              <th scope="col">Title</th>
              <th scope="col">Person</th>
              <th scope="col">Publisher</th>
              <th scope="col">Price</th>
            </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
        <div id="pager">
            <nav aria-label="Page navigation example">
              <ul class="pagination">
                <li class="page-item disabled" id="prevTen">
                  <a class="page-link" aria-label="PrevTen">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </li>
                <li class="page-item page-num"><a class="page-link">1</a></li>
                <li class="page-item disabled" id="nextTen">
                  <a class="page-link" aria-label="NextTen">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>
              </ul>
            </nav>
            <input type="hidden" id="curPage" value="1"/>
        </div>
    </div>

</div>

<script>

(function (window, $, undefined) {

    var bookSearchPage = {
        init: function() {
            this.eventBinding();
            $('#login').hide();
            $('#logout').show();
        },
        eventBinding: function() {
            $('#searchBtn').click(function() {
                var keyword = $('#keyword').val();
                var type = $('#type').val();
                var keyLen = $('#keyword').val().trim().length;
                if (keyLen < 1) {
                    alert('please insert keyword');
                    return;
                }
                $('#curPage').val(1);
                bookSearchPage.requestGetBook(type, keyword, 1);
                $('#searchedType').val(type);
                $('#searchedKeyword').val(keyword);
            });

            $('.pagination #prevTen').on('click', function(e) {
                var isDisbled = $(e.target).hasClass('disabled');
                if (!isDisbled) {
                    var prevPage = Number($('.page-num:first a').text()) - 10;
                    $('#curPage').val(prevPage);
                    bookSearchPage.requestGetBook($('#searchedType').val(), $('#searchedKeyword').val(), prevPage);
                }
            });
            $('.pagination #nextTen').on('click', function(e) {
                var isDisbled = $(e.target).hasClass('disabled');
                if (!isDisbled) {
                    var nextPage = Number($('.page-num:last a').text()) + 1;
                    $('#curPage').val(nextPage);
                    bookSearchPage.requestGetBook($('#searchedType').val(), $('#searchedKeyword').val(), nextPage);
                }

            });
        },
        requestGetBook: function(type, keyword, page) {
            var searchKeyword = encodeURI(keyword, 'UTF-8');
            $.get('/book/search/' + type + '/' + searchKeyword,
                {records: $('#records').val(), page: page})
                .done(function (data) {
                    console.log(data);
                    bookSearchPage.bindingTableData(data);

                })
                .fail(function (data, status) {
                    console.log(data, status);
                });

        },
        bindingTableData: function(data, isPage) {
            var bodyHtml;
            $.each(data.rows, function(i, ele) {
                var rowHtml = '<tr>'
                              //+'  <th scope="row">'+(i+1)+'</th>'
                              +'  <td><a href="/book/detail/'+ele.isbn+'">'+ele.title+'</a></td>'
                              +'  <td>'+ele.authors+'</td>'
                              +'  <td>'+ele.publisher+'</td>'
                              +'  <td>'+ele.price+'</td>'
                              +'</tr>';
                bodyHtml += rowHtml;
            });
            $('#bookTable tbody').html('');
            $('#bookTable tbody').append(bodyHtml);

            if (!isPage) {
                var pageCnt = data.pageCnt;
                $('#total').text(data.total);
                bookSearchPage.settingPagenav(pageCnt);
                $('.page-num:first').addClass('active');
            }
        },
        settingPagenav: function(pageCnt) {
            var curPage = $('#curPage').val();
            var start = parseInt(curPage / 10);
            start = start * 10 + 1;
            var end = start + 9;
            end = end > pageCnt ? pageCnt : end;

            if (pageCnt > 1) {
                var addHtml = '';
                for (i=start; i<=end; i++) {
                    var pageHtml = '<li class="page-item page-num"><a class="page-link">'+i+'</a></li>';
                    addHtml += pageHtml;
                }
                $('.pagination .page-num').remove();
                $('.pagination li:first').after(addHtml);

                // per ten button
                if (start - 10 > 0) {
                    $('#prevTen').removeClass('disabled');
                } else {
                    $('#prevTen').addClass('disabled');
                }

                if (end + 1 <= pageCnt) {
                    $('#nextTen').removeClass('disabled');
                } else {
                    $('#nextTen').addClass('disabled');
                }

            }

            // number paging
            $('.pagination li.page-num').click(function(e) {
                e.preventDefault();
                console.log(e.target);
                $('.pagination .page-num').removeClass('active');
                $(e.target).parent().addClass('active');

                var type = $('#searchedType').val();
                var keyword = $('#searchedKeyword').val();
                var searchKeyword = encodeURI(keyword, 'UTF-8');
                var page = $('.pagination li.active a').text();
                page = (page=='') ? 1 : page;
                $.get('/book/search/' + type + '/' + searchKeyword,
                    {records: $('#records').val(), page: page})
                    .done(function (data) {
                        console.log(data);
                        bookSearchPage.bindingTableData(data, true);
                    })
                    .fail(function (data, status) {
                        console.log(data, status);
                    });
                $('#curPage').val(page);
            });
        }
    };

    $(document).ready(function () {
        bookSearchPage.init();
    });

})(window, jQuery);

</script>