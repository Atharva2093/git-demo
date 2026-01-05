# Employee polymorphism demonstration

class Employee:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary
    
    def calculate_salary(self):
        return self.salary

class PermanentEmployee(Employee):
    def __init__(self, name, base_salary, bonus):
        super().__init__(name, base_salary)
        self.bonus = bonus
    
    def calculate_salary(self):
        return self.salary + self.bonus

class ContractEmployee(Employee):
    def __init__(self, name, hourly_rate, hours_worked):
        super().__init__(name, hourly_rate)
        self.hours_worked = hours_worked
    
    def calculate_salary(self):
        return self.salary * self.hours_worked

# Demonstrate polymorphism
employees = [
    PermanentEmployee("Alice", 50000, 10000),
    ContractEmployee("Bob", 500, 160),
    PermanentEmployee("Charlie", 60000, 15000),
    ContractEmployee("David", 600, 150)
]

print("Employee Salaries:")
print("-" * 40)
for emp in employees:
    total_salary = emp.calculate_salary()
    print(f"{emp.name}: ${total_salary:,.2f}")




