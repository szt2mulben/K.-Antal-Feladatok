var segedgep = 'X';
var segedjatekos = 'O';
var szamitogep;
var seged = [1, -1, -1, -1, 1, 1, 1, -1, -1];
var nyerestabla = [
  [0, 1, 2],
  [3, 4, 5],
  [6, 7, 8],
  [0, 3, 6],
  [1, 4, 7],
  [2, 5, 8],
  [0, 4, 8],
  [2, 4, 6]
];
function renderBoard(tabla) {
  tabla.forEach(function(el, i) {
    var id = '#' + i.toString();
    if (el === -1) {$(id).text(segedjatekos);} else if (el === 1) {$(id).text(segedgep);}
  });
  $('.hely:contains(X)').addClass('jatekosx');
  $('.hely:contains(O)').addClass('jatekoso');
}
function animateWinLine() {
  var id = nyerestabla.map(function(nyeres) {return nyeres.map(function(nyeres1) {return seged[nyeres1];
    }).reduce(function(prev, cur) {return prev + cur;});});
}
function chooseMarker() {
  $('.valasztas-container').css('display', 'block');
  $('.gomb span').click(function() {
    var segedj = $(this).text();
    segedjatekos = (segedj === 'X' ? 'X' : 'O');
    segedgep = (segedj === 'X' ? 'O' : 'X');
    setTimeout(function() {
      $('.valasztas-container').css('display', 'none');
      $('.valasztas1').css('display','none');
      startNewGame();
    }, 700);
    $('.gomb span').off();
  });
}
function endGameMessage(){
  var vege = checkVictory(seged);
  $('.vegecucc h3').text(vege === 'Nyertél' ? 'Vesztettél' : "Döntetlen!");
  $('.valasztas-container').css('display', 'block');
  $('.vegecucc').css('display','block')
  $('.gomb span').click(function() {
    setTimeout(function() {
      $('.valasztas-container').css('display', 'none');
      startNewGame();
    }, 700);
    $('.gomb span').off();
  });
}
function startNewGame() {
  seged = [0, 0, 0, 0, 0, 0, 0, 0, 0];
  $('.hely').text("").removeClass('jatekoso jatekosx');
  renderBoard(seged);
  playerTakeTurn();
}
function playerTakeTurn() {
  $('.hely:empty').hover(function() {
    $(this).text(segedjatekos).css('cursor', 'pointer');
  }, function() { $(this).text('');});
  $('.hely:empty').click(function() {
    $(this).css('cursor', 'default');
    seged[parseInt($(this).attr('id'))] = -1;
    renderBoard(seged);
    if (checkVictory(seged)) {    
      setTimeout(endGameMessage,(checkVictory(seged) === 'Nyertél') ? 700 : 100);
    } else {setTimeout(aiTakeTurn, 100);}
    $('.hely').off();
  });
}
function aiTakeTurn() {
  miniMax(seged, 'szamitogep');
  seged[szamitogep] = 1;
  renderBoard(seged);
  if (checkVictory(seged)) {
    animateWinLine();
    setTimeout(endGameMessage, checkVictory(seged) === 'Nyertél' ? 700 : 100);
  } else {
    playerTakeTurn();
  }
}
function checkVictory(tablas) {
  var negyzet = tablas.reduce(function(prev, cur) {
    return Math.abs(prev) + Math.abs(cur);
  });
  var ered = nyerestabla.map(function(nyeress) {
    return nyeress.map(function(nyeress1) {
      return tablas[nyeress1];
    }).reduce(function(prev, cur) {return prev + cur;});
  }).filter(function(teljes) {return Math.abs(teljes) === 3;});

  if (ered[0] === 3) {return 'Nyertél';} else if (ered[0] === -3) {return 'Vesztettél';} else if (negyzet === 9) {return 'Döntetlen';
  } else {return false;}
}
function availableMoves(tablas1) {
  return tablas1.map(function(el, i) {
    if (!el) {return i;}
  }).filter(function(e) {return (typeof e !== "undefined");});
}
function miniMax(allapot, jatek) {
  var rv = checkVictory(allapot);
  if (rv === 'Nyertél') {return 10;}
  if (rv === 'Vesztettél') {return -10;}
  if (rv === 'Döntetlen') {return 0;}
  var lep = [];
  var pont = [];
  availableMoves(allapot).forEach(function(negyzet) {
    allapot[negyzet] = (jatek === 'szamitogep') ? 1 : -1;
    pont.push(miniMax(allapot, (jatek === 'szamitogep') ? 'ellenfél' : 'szamitogep'));
    lep.push(negyzet);
    allapot[negyzet] = 0;
  });
  if (jatek === 'szamitogep') {szamitogep = lep[pont.indexOf(Math.max.apply(Math, pont))]; return Math.max.apply(Math, pont);
  } else {szamitogep = lep[pont.indexOf(Math.min.apply(Math, pont))];return Math.min.apply(Math, pont);}
}
renderBoard(seged);
chooseMarker();