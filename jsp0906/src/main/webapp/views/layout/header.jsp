<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/layout.css">
			<nav class="navbar navbar-expand-lg navbar-light bg-light"  >
		  <div class="container-fluid">
		    <a class="navbar-brand" href="main.do">main</a>																					
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item dropdown px-3">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            회원관리
		          </a>
		          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		            <li><a class="dropdown-item" href="sawonList.do">회원조회</a></li>
		            <li><a class="dropdown-item" href="sawonWrtieForm.do">회원등록</a></li>
		          </ul>
		        </li>

		        <li class="nav-item dropdown px-3">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            제품관리
		          </a>
		          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		            <li><a class="dropdown-item" href="itemList.do">제품조회</a></li>
		            <li><a class="dropdown-item" href="itemWriteForm.do">제품등록</a></li>
		          </ul>
		        </li>

		        <li class="nav-item dropdown px-3">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            거래처관리
		          </a>
		          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		            <li><a class="dropdown-item" href="customList.do">거래처조회</a></li>
		            <li><a class="dropdown-item" href="customWriteForm.do">거래처등록</a></li>
		          </ul>
		        </li>

		        <li class="nav-item dropdown px-3">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            주문관리
		          </a>
		          <ul class="dropdown-menu px-3" aria-labelledby="navbarDropdown">
		            <li><a class="dropdown-item" href="#">주문조회</a></li>
		            <li><a class="dropdown-item" href="#">주문등록</a></li>
		          </ul>
		        </li>
		        

		      </ul>
		      <form class="d-flex">
		        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
		        <button class="btn btn-outline-success" type="submit">Search</button>
		      </form>
		    </div>
		  </div>
</nav>   