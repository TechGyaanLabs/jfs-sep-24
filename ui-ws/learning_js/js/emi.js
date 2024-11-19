
function calculateEMI(){
    var amount = document.getElementById("idLoanAmount").value;
    var rate = document.getElementById("idInterestRate").value;
    var duration = document.getElementById("idLoanTenure").value;


    // Validation of input

    if(amount == "" || rate == "" || duration == ""){
        alert("Please enter all the values");
        return;
    }

    // Validate positive values

    if(amount <= 0 || rate <= 0 || duration <= 0){
        alert("Please enter positive values");
        return;
    }

    // Calculate EMI

    rate = rate / 1200;

    let emi = amount * rate * Math.pow(1 + rate, duration) / (Math.pow(1 + rate, duration) - 1);

    let formattedEmiAmount = emi.toFixed(2);
    let totalAmount = (emi * duration).toFixed(2);
    let totalInterest = (totalAmount - amount).toFixed(2);

    document.getElementById("idEMIResult").innerHTML = `EMI: ${formattedEmiAmount} <br> Total Amount: ${totalAmount} <br> Total Interest: ${totalInterest}`;

}