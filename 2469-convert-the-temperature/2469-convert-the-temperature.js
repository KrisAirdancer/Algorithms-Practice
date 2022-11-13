/**
 * @param {number} celsius
 * @return {number[]}
 */
var convertTemperature = function(celsius)
{
    let results = [];
    results.push(celsius + 273.15);
    results.push((celsius * 1.80) + 32.00);
    console.log(results);
    
    return results;
};