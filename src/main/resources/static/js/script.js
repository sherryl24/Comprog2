document.addEventListener('DOMContentLoaded', () => {
    const removeForms = document.querySelectorAll('.remove-form, .remove-item-shortcut');

    removeForms.forEach(form => {
        form.addEventListener('submit', (event) => {
            const isConfirmed = confirm('Are you sure you want to remove this item from the cart? This action cannot be undone.');

            if (!isConfirmed) {
                event.preventDefault();
            }
        });
    });

    const urlParams = new URLSearchParams(window.location.search);
    const status = urlParams.get('status');
    const message = urlParams.get('message');
    const messageContainer = document.getElementById('feedback-message');

    if (status && message && messageContainer) {
        const alertDiv = document.createElement('div');
        alertDiv.textContent = decodeURIComponent(message.replace(/\+/g, ' '));

        alertDiv.classList.add('alert', status);

        messageContainer.appendChild(alertDiv);

        setTimeout(() => {

            alertDiv.style.opacity = '0';
            setTimeout(() => alertDiv.remove(), 500);
        }, 5000);
    }
});