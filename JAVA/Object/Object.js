console.log("1. feladat:")
let user = {};
user.firstName = 'John';
user.lastName = 'Smith';
user.firstName = 'Paul';
delete user.firstName;

console.log(user);

console.log("\n2. feladat:")
function isEmpty(obj) {
    for (let key in obj) {
        if (obj.hasOwnProperty(key)) {
            return false;
        }
    }
    return true;
}

console.log(isEmpty({}));
console.log(isEmpty({name: "John"}));

console.log("\n3. feladat:")
let fizetes = {
    Anna: 2100,
    Cecil: 1890,
    Emil: 2050,
    Gerald: 2920
};

let osszeg = 0;
for (let szemely in fizetes) {
    osszeg += fizetes[szemely];
    console.log(`${szemely} fizetése: ${fizetes[szemely]} Ft`);
}

console.log(`Az összesített fizetés: ${osszeg} Ft`);