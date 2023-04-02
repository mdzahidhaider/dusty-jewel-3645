// Get the cart items
const cartItems = document.querySelectorAll('.cart-item');

// Loop through each cart item and add event listener to remove button
cartItems.forEach(function(item) {
    const removeButton = item.querySelector('.remove-item');
    removeButton.addEventListener('click', function() {
        item.remove();
        updateCartTotal();
    });
});

// Update the total price of all cart items
function updateCartTotal() {
    const cartItems = document.querySelectorAll('.cart-item');
    let total = 0;
    cartItems.forEach(function(item) {
        const priceElement = item.querySelector('.item-price');
        const price = parseFloat(priceElement.textContent.replace('$', ''));
        total += price;
    });
    const totalPriceElement = document.querySelector('.total-price');
    totalPriceElement.textContent = '$' + total.toFixed(2);
}