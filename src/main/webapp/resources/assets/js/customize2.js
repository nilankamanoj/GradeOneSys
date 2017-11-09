var countryLists = new Array(10)
countryLists["empty"] = ["Select a district"];
countryLists["Northern"] = ["Jaffna", "Kilinochchi", "Mannar","Mullaitivu","Vavuniya"];
countryLists["NorthWestern"] = ["Puttalam", "Kurunegala"];
countryLists["Western"] = ["Gampaha", "Colombo", "Kaluthara"];
countryLists["NorthCentral"] = ["Anuradhapura", "Polonnaruwa"];
countryLists["Central"] = ["Matale", "Kandy", "NuwaraEliya"];
countryLists["Sabaragamuwa"] = ["Kegalle", "Ratnapura"];
countryLists["Eastern"] = ["Trincomalee", "Batticaloa", "Ampara"];
countryLists["Uva"] = ["Badulla", "Monaragala"];
countryLists["Southern"] = ["Hambantota", "Matara", "Galle"];

/* CountryChange() is called from the onchange event of a select element.
* param selectObj - the select object which fired the on change event.
*/
function countryChange(selectObj) {
    // get the index of the selected option
    var idx = selectObj.selectedIndex;
    // get the value of the selected option
    var which = selectObj.options[idx].value;
    // use the selected option value to retrieve the list of items from the countryLists array
    cList = countryLists[which];
    // get the country select element via its known id
    var cSelect = document.getElementById("country");
    // remove the current options from the country select
    var len=cSelect.options.length;
    while (cSelect.options.length > 0) {
        cSelect.remove(0);
    }
    var newOption;
    // create new options
    for (var i=0; i<cList.length; i++) {
        newOption = document.createElement("option");
        newOption.value = cList[i];  // assumes option string and value are the same
        newOption.text=cList[i];
        // add the new option
        try {
            cSelect.add(newOption);  // this will fail in DOM browsers but is needed for IE
        }
        catch (e) {
            cSelect.appendChild(newOption);
        }
    }
}