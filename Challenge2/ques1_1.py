class Product:
    def __init__(self, name, price, quantity):
        self.name = name
        self.price = price
        self.quantity = quantity
        
inventory = [
    Product("Laptop", 999.99, 5),
    Product("Smartphone", 499.99, 10),
    Product("Tablet", 299.99, 0),
    Product("Smartwatch", 199.99, 3)
]

def calculate_total_value(inventory):
    total_value = 0
    for product in inventory:
        total_value += product.price * product.quantity
    return total_value

def find_most_expensive_product(inventory):
    most_expensive_product = None
    for product in inventory:
        if most_expensive_product is None or product.price > most_expensive_product.price:
            most_expensive_product = product
    return most_expensive_product

def check_product_in_inventory(inventory, product_name):
    for product in inventory:
        if product.name == product_name:
            return True
    return False

def sort_products_by_price_asc(inventory):
    return sorted(inventory, key=lambda x: x.price)

def sort_products_by_price(inventory):
    return sorted(inventory, key=lambda x: x.price, reverse=True)

def sort_products_by_quantity(inventory):
    return sorted(inventory, key=lambda x: x.quantity)

def sort_products_by_quantity_desc(inventory):
    return sorted(inventory, key=lambda x: x.quantity, reverse=True)

