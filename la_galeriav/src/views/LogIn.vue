<template>
    <div id="containerLogIn">
        <h1 class="tituloLogIn">Log In</h1>
        <form class="formularioLogIn">
            <input type="text" class="rounded" placeholder="Username">
            <input type="password" class="rounded" placeholder="Password">
            <button class="login">Log In</button>
        </form>
    </div>
</template>

<style>
    #containerLogIn {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #F0F0F0;
    }

    .tituloLogIn {
        color: blue;
    }

    .rounded {
        border: 1px solid #ccc;
        border-radius: 10px;
        padding: 10px;
        margin-bottom: 10px;
        width: 300px;
    }

    .login {
        background-color: blue;
        color: white;
        border: none;
        border-radius: 10px;
        padding: 10px 20px;
        cursor: pointer;
    }
</style>