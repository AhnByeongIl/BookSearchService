<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<form>
  <div class="form-group row">
    <label for="title" class="col-sm-2 col-form-label">제목</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="title" value="${bookInfo.title}">
    </div>
  </div>
  <div class="form-group row">
    <label for="thumbnail" class="col-sm-2 col-form-label">Thumbnail</label>
    <div class="col-sm-10">
      <img src="${bookInfo.thumbnail}" alt="" class="img-thumbnail">
    </div>
  </div>
  <div class="form-group row">
    <label for="contents" class="col-sm-2 col-form-label">소개</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="contents" value="${bookInfo.contents}">
    </div>
  </div>
  <div class="form-group row">
    <label for="isbn" class="col-sm-2 col-form-label">ISBN</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="isbn" value="${bookInfo.isbn}">
    </div>
  </div>
  <div class="form-group row">
    <label for="authors" class="col-sm-2 col-form-label">저자</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="authors" value="${bookInfo.authors}">
    </div>
  </div>
  <div class="form-group row">
    <label for="publisher" class="col-sm-2 col-form-label">출판사</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="publisher" value="${bookInfo.publisher}">
    </div>
  </div>
  <div class="form-group row">
    <label for="price" class="col-sm-2 col-form-label">정가</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="price" value="${bookInfo.price}">
    </div>
  </div>
  <div class="form-group row">
    <label for="salePrice" class="col-sm-2 col-form-label">판매가</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="salePrice" value="${bookInfo.salePrice}">
    </div>
  </div>
  <div class="form-group row">
    <label for="url" class="col-sm-2 col-form-label">Link</label>
    <div class="col-sm-10">
      <a href="${bookInfo.url}">${bookInfo.url}</a>
    </div>
  </div>
</form>