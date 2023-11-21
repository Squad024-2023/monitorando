/*observer pras animações no scroll*/
const observer = new IntersectionObserver((entries) => {
  entries.forEach((entry) => {
    console.log(entry)
    if (entry.isIntersecting) {

      entry.target.classList.add('animate');
    }
    /*else {
         entry.target.classList.remove('animate');
       }*/

  });
});


const hiddenElements = document.querySelectorAll('.ani');
hiddenElements.forEach((el) => observer.observe(el));


/*observer pras animações no scroll*/
const observer2 = new IntersectionObserver((entries) => {
  entries.forEach((entry) => {
    console.log(entry)
    if (entry.isIntersecting) {

      entry.target.classList.add('animate2');
    }

  }, {
    threshold: 1
  });
});


const hiddenElements2 = document.querySelectorAll('.ani2');
hiddenElements2.forEach((el) => observer2.observe(el));
