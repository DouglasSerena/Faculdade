function message(message, type) {
    const body = document.querySelector('body');
    body.innerHTML += `
        <div id="message" class="message bg-${type}">
            <p>${message}</p>
        </div>`;
    setTimeout(() => {
        const messageElement = document.querySelector('#message');
        messageElement.classList.add('messageClose');
    }, 5000);
    const url = window.location;
    window.history.pushState(null, null, url.origin + url.pathname);
}
