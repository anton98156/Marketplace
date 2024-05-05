document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector('form');

    form.addEventListener('submit', function(event) {
        const nameFieldValue = document.getElementById("name").value;
        const descriptionFieldValue = document.getElementById("description").value;
        const priceFieldValue = document.getElementById("price").value;

        if (nameFieldValue.trim() === "" || descriptionFieldValue.trim() === "" || priceFieldValue.trim() === "") {
            alert("Пожалуйста, заполните все поля.");
            event.preventDefault(); // Блокирование формы.
            return false;
        }

        if (isNaN(parseFloat(priceFieldValue))) {
            alert("Пожалуйста, введите корректную цену.");
            event.preventDefault(); // Блокирование формы.
            return false;
        }

        return true; // Отправление формы.
    });
});