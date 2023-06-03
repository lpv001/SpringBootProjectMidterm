let category = document.querySelectorAll(".Menu")
let cool = document.getElementById('cool')
let hot = document.getElementById('hot')
let frappe = document.getElementById('frappe')
let food = document.getElementById('food')
let order_page = document.getElementById('ord')
let receipt_page = document.getElementById('rec')

category[0].style.display = 'flex'
category[1].style.display = 'none'
category[2].style.display = 'none'
category[3].style.display = 'none'

cool.onclick = () => {
    category[0].style.display = 'flex'
    category[1].style.display = 'none'
    category[2].style.display = 'none'
    category[3].style.display = 'none'
}

hot.onclick = () => {
    category[0].style.display = 'none'
    category[1].style.display = 'flex'
    category[2].style.display = 'none'
    category[3].style.display = 'none'
}

frappe.onclick = () => {
    category[0].style.display = 'none'
    category[1].style.display = 'none'
    category[2].style.display = 'flex'
    category[3].style.display = 'none'
}

food.onclick = () => {
    category[0].style.display = 'none'
    category[1].style.display = 'none'
    category[2].style.display = 'none'
    category[3].style.display = 'flex'
}

let cf_order = document.getElementById('cf-order')
var order_array = []
var order_object = {
    drink_id: null,
    size: '',
    sugar: '',
    zone: '',
    quantity: '',
    price: '',
    name: '',
    cream: false
}
let html = document.getElementById('list')
let string = ''
var ct = null

function setsize(size){
    order_object.size = size
}
function setcream(){
    order_object.cream = !order_object.cream
}
function setsurgar(){
    let e = ct.querySelector("#Sugar");
    let sugar = e.options[e.selectedIndex].text;
    order_object.sugar = sugar
}
function setzone(){
    let e = ct.querySelector("#Zone");
    let zone = e.options[e.selectedIndex].text;
    order_object.zone = zone
}
function setquantity(){
    let quantity = ct.querySelector("#Quantity").value
    order_object.quantity = quantity
}

function setPrice(){
    let price = ct.parentNode.querySelector("#price").innerHTML   
    order_object.price = price
}

function setName(){
    let name = ct.parentNode.querySelector("#order_btn").innerHTML
    order_object.name = name
}

function SelectOption(id, type) {
    ct = document.getElementById("myOption" + type)
    ct.style.display = "block"
    order_object.drink_id = id
}

function closeForm(type) {
    order_object = {}
    document.getElementById("myOption" + type).style.display = "none";
}

function setDetail(type) {
    setsurgar()
    setzone()
    setquantity()
    setPrice()
    setName()
    order_array.push(order_object)
    order_object = {}
    ct = null
    document.getElementById("myOption" + type).style.display = "none"
    processlist(order_array)
}

function processlist(array){
    let string = ''
    array.forEach((data) => {
        string +=
        `
        <div class="list">
            <p>${data.drink_id}</p>
            <p>${data.name}</p>
            <p>${data.size}</p>
            <p>${data.quantity}</p>
            <p>${data.price} $</p>
            <p>
                <span>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L6.832 19.82a4.5 4.5 0 01-1.897 1.13l-2.685.8.8-2.685a4.5 4.5 0 011.13-1.897L16.863 4.487zm0 0L19.5 7.125" />
                    </svg>                                      
                </span>
                <span onclick="erase_array(${data.drink_id})">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M14.74 9l-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 01-2.244 2.077H8.084a2.25 2.25 0 01-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 00-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 013.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 00-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 00-7.5 0" />
                    </svg>                                      
                </span>
            </p>
        </div>
        `
    })
    html.innerHTML = string
}

function erase_array(drink_id) {
    order_array = order_array.filter((data) => (data.drink_id != drink_id))
    processlist(order_array)
}

let confirm_button = document.getElementById('confirm_button')
var total_price = 0
var order_arr = []
var order_obj = {
    total_price: ''
}
confirm_button.onclick = () => {
    order_page.style.display = "none"
    receipt_page.style.display = "block"

    let id_holder = []
    let name_holder = []
    let quantity_holder = []
    let unit_price_holder = []
    let total_price_holder = []
    

    order_array.forEach(data => {
        console.log(data)
        id_holder.push(data.drink_id)
        name_holder.push(data.name)
        quantity_holder.push(data.quantity)
        unit_price_holder.push(data.price)
        total_price_holder.push(parseInt(data.quantity)*parseFloat(data.price).toFixed(2))
    })
    
    total_price_holder.forEach((p) => total_price += p)

    let dc = document.getElementById('description')
    let str_dc = '<h4>Description</h4>'

    name_holder.forEach((name) => {
        str_dc += `<p>${name}</p>`
    })

    let qt = document.getElementById('qt')
    let str_qt = '<h4>Quantity</h4>'

    quantity_holder.forEach((qt) => {
        str_qt += `<p>${qt}</p>`
    })

    str_qt += `
        <p>Sub Total</p>
        <p style="text-align: start; margin-top: 40px">Grand Total($)</p>
        <p style="text-align: start">Grand Total(R)</p>
        <hr>
    `

    let un = document.getElementById('un')
    let str_un = '<h4>Unit Price</h4>'

    unit_price_holder.forEach((un) => {
        str_un += `<p>${un}</p>`
    })

    let am = document.getElementById('am')
    let str_am = '<h4>Unit Price</h4>'

    total_price_holder.forEach((am) => {
        str_am += `<p>${am}</p>`
    })

    str_am += `<p>${total_price}</p>`
    str_am += `<p style="text-align: start; margin-top: 40px">${total_price}</p>`
    str_am += `<p style="text-align: start; margin-top: 40px">${total_price * 4100}</p>`

    dc.innerHTML = str_dc
    qt.innerHTML = str_qt
    un.innerHTML = str_un
    am.innerHTML = str_am

    order_obj.total_price = `${total_price}`

    order_arr.push(order_obj)

}
let cancel_order = document.getElementById('cancel_order')
cancel_order.onclick = () => {
    order_page.style.display = "block"
    receipt_page.style.display = "none"
}

let form = document.getElementById('ordering')

form.addEventListener('submit', (e) => {

    e.preventDefault()

    $.ajax({
        url: "/giccafe/order_record",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            order: order_arr
        }),
        success: function (res) {
            console.log("post successfully")
        },
        error: function (jqXHR, textStatus, errorThrown){
            console.log(textStatus)
            alert(textStatus)
        }
    })

    window.setTimeout(() => {
        $.ajax({
            url: "/giccafe/ordering",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                orders: order_array
            }),
            success: function (res) {
                console.log("post successfully")
            },
            error: function (jqXHR, textStatus, errorThrown){
                console.log(textStatus)
                alert(textStatus)
            }
        })

        html.innerHTML = ''
        order_object = {}
        order_array = []

        alert("Order successfuly!")
        location.reload()

    },2000)


    // 
    order_obj = {}
    order_arr = []

})

receipt_page.style.display = "none"
