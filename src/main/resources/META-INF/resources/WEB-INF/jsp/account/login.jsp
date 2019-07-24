    <form class="login-form" method="POST">
        <input type ="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>
        <div class="row">
            <div class="input-field col s12">
                <input id="id" type="text" name="username" class="validate"/>
                <label for="id">ID</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="password" type="password" name="password" class="validate"/>
                <label for="password">Password</label>
            </div>
        </div>
        <input class="login-btn waves-effect waves-light btn" type="submit" value="LOGIN" />
    </form>