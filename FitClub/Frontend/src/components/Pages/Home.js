import React from "react";
import './Home.css';

// Import your images
import heroImg from '../../assets/heroimg.png';
import lunges from '../../assets/lunges.png';
import yoga from '../../assets/yoga-pose.png';
import ex from '../../assets/extended.png';
import trainer from '../../assets/trainer.png';

export const Home = () => {
  return (
    <div>
      {/* Section 1: Hero Section */}
      <section id='hero'>
        <div className="container">
          <div className="hero__wrapper">
            <div className="hero__content">
              <br/>
              <br/>
              <h2 className='section__title'>
                Exercise is the key to a <span className="highlights">Healthy</span> Lifestyle
              </h2>
              <p>
                Regular exercise is a crucial component of a healthy lifestyle.<br/>
                It has numerous benefits for physical and mental health, including reducing the risk of chronic diseases, improving cardiovascular function,<br/>
                enhancing mood, reducing stress, and promoting better sleep.
              </p>
              {/* <div className="hero__btns">
                <button className='register__btn'>Get Started</button>
                <button className='watch_btn'>
                  <span><i className="ri-play-fill"></i></span>Watch Video
                </button>
              </div> */}
            </div>
            <div className='hero__img'>
              <div className="hero__img-wrapper">
                <div className="box-01">
                  <div className="box-02">
                    <div className="box-03">
                      <div className="box__img">
                        <img src={heroImg} alt="Exercise" />
                      </div>
                    </div>
                  </div>
                </div>
                {/* <div className="heart__rate">
                  <h5>Heart Rate</h5>
                  <span><i className="ri-heart-pulse-fill"></i></span>
                  <h6>100 BPM</h6>
                </div> */}
                {/* <div className="gym__location">
                  <span><i className="ri-map-pin-2-fill"></i></span>
                  <h5>Find our gym centers near you</h5>
                </div> */}
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* Section 2: Benefits of Exercise */}
      <section>
      <div className="container exercise__top">
        <h2 className="section__title">Benefits of <span className="highlights">Exercise</span></h2>
        <p>Exercise is essential for maintaining a healthy body and mind,<br/> and can improve quality of life in numerous ways.</p>
        <div className="exercise__wrapper">
          {[{
            img: lunges,
            title: 'Healthy Life',
            desc: 'Living a healthy life involves taking care of both your physical and mental health.'
          }, {
            img: yoga,
            title: 'Increased Flexibility',
            desc: 'Increased flexibility is an important aspect of physical fitness that can offer a range of benefits.'
          }, {
            img: ex,
            title: 'Reducing Blood Pressure',
            desc: 'Regular physical activity can help lower blood pressure and improve overall cardiovascular health.'
          }].map(({ img, title, desc }, index) => (
            <div key={index} className="exercise__item" data-aos-duration="1500" data-aos="zoom-in">
              <span className="exercise__icon"><img src={img} alt={title} /></span>
              <div className="exercise__content">
                <h4>{title}</h4>
                <p>{desc}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>

      {/* Section 3: Subscription Plans */}
      <section id='membership'>
        <div className="container">
          <div className="pricing__top">
            <h2 className="section__title">Premium <span className="highlights">Subscription</span> plan</h2>
            <p>Health & Fitness is a popular exercise tracking app that offers a premium subscription service.<br />The premium version includes advanced nutrient tracking, customized goals and advice, and exclusive content.</p>
          </div>

          <div className="pricing__wrapper">
            <div className="pricing__item" data-aos-duration="1500" data-aos="fade-up">
              <div className="pricing__card-top">
                <h2 className=''>Regular Member</h2>
                <h2 className="pricing">$9.99 <span>/month</span></h2>
              </div>

              <div className="services">
                <ul>
                  <li>Unlimited access to the App</li>
                  <li>Customer support</li>
                  <li>Personal trainer</li>
                  <li>Personal Nutritionist</li>
                  <li>Demo online classes</li>
                </ul>

                <button className='register__btn'>Buy Now</button>
              </div>
            </div>

            <div className="pricing__item pricing__item-02" data-aos-duration="1500" data-aos="fade-up">
              <div className="pricing__card-top">
                <h2 className=''>Gold Member</h2>
                <h2 className="pricing">$79.99 <span>/year</span></h2>
              </div>

              <div className="services">
                <ul>
                  <li>Unlimited access to the App</li>
                  <li>Customer support</li>
                  <li>Personal trainer</li>
                  <li>Personal Nutritionist</li>
                  <li>Free online classes</li>
                  <li>Free access to our gym centers</li>
                </ul>

                <button className='register__btn'>Buy Now</button>
              </div>
            </div>

            <div className="pricing__item" data-aos-duration="1500" data-aos="fade-up">
              <div className="pricing__card-top">
                <h2 className=''>Standard Member</h2>
                <h2 className="pricing">$49.99 <span>/year</span></h2>
              </div>

              <div className="services">
                <ul>
                  <li>Unlimited access to the App</li>
                  <li>Customer support</li>
                  <li>Personal trainer</li>
                  <li>Personal Nutritionist</li>
                  <li>Free online classes</li>
                </ul>
                <button className='register__btn'>Buy Now</button>
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* Section 4: Call to Action */}
      <section id='call-to-action'>
        <div className="container">
          <div className="start__wrapper">
            <div className="start__img" style={{ width: '50%', maxWidth: '400px' }}>
              <img src={trainer} alt="Personal Trainer" style={{ width: '100%', height: 'auto' }} />
            </div>
            <div className="start__content">
              <h2 className="section__title">
                Ready to make <span className="highlights">Change?</span>
              </h2>
              <p>
                Remember, it's important to start slowly and gradually increase the intensity and duration of your exercise routine. Consult us as your healthcare provider before starting any new exercise program. Good luck, and enjoy the journey with us towards a healthier you!
              </p>
              <button className="register__btn"><a href="/login">Get Started</a></button>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};
