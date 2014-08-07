(ns sketch.core
  (:require [hiccup.core :as h]
            ))
(h/html [:svg {:height 100 :width 100} (render-svg [:pulse {:angle 90} :pulse {:angle 180} :delay {:label "T_d"}])])

(defn render-svg [pulse-seq]
  (apply str (map render-elem (partition 2 pulse-seq))))

;; (defn render-elem [elem]
;;   (let [elem-type (first elem)
;;         elem-attr (second elem)]
;;     (case elem-type
;;       :pulse
;;       (h/html [:rect (into {:height 10} (pulse-attr elem-attr))])
;;       )))

(defmulti render-elem first)

(defmethod render-elem :pulse [elem]
  (str "pulse " elem))
(defmethod render-elem :delay [elem]
  (str "delay " elem))
(defmethod render-elem :aq [elem]
  (str "aq " elem))


(defn pulse-attr [attr]
  {:width 50})
