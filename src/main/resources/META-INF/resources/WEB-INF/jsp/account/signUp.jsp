    <form class="signup-form" action="/account/create" method="POST">
        <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />

        <div class="row">
            <div class="input-field col s12">
                <input id="user_id" name="uid" type="text" class="validate"/>
                <label for="user_id">User ID</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="user_name" name="userName" type="text" class="validate"/>
                <label for="user_name">Username</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="password" name="pwd" type="password" class="validate"/>
                <label for="password">Password</label>
            </div>
        </div>
        <input class="signup-btn waves-effect waves-light btn" type="submit" value="Sign Up" />
    </form>