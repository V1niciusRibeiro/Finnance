  
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Renda Fixa',     200],
          ['FIIs',      500],
          ['Ações',  230],
        ]);

        var options = {
         
          pieHole: 0.6,
          width: 300,

          colors: ['#4D84B6', '#4EEAE0', '#94FCCA'],
          
         
        };

        var chart = new google.visualization.PieChart(document.getElementById('grafico'));
        chart.draw(data, options);
        
        const btn = document
        .querySelector('.read-more-btn');

	    const text = document
	        .querySelector('.card__read-more');
	
	    const cardHolder = document
	        .querySelector('.card-holder');
	
	    cardHolder
	        .addEventListener('click', e => {
	
	            const current = e.target;
	
	            const isReadMoreBtn = current.className.includes('read-more-btn');
	
	            if (!isReadMoreBtn)
	                return;
	
	            const currentText = e.target.parentNode.querySelector('.card__read-more');
	
	            currentText.classList.toggle('card__read-more--open');
	
	            current.textContent = current.textContent.includes('Mais Detalhes') ? 'Menos Detalhes' : 'Mais Detalhes';

        });     
      }
