# 21.Модель обслуживания на бензозаправочной станции
Требуется создать компьютерную модель обслуживания потока
заявок, поступающих от владельцев автомашин, несколькими (3≤ K ≤ 7)
разливочными автоматами на бензозаправочной
станции.
Бензозаправочная станция работает круглосуточно. При моделировании ее
работы заявки на обслуживание (т.е. приезд автомашин на заправку) поступают
случайным образом: случайной величиной является отрезок времени между
появлением двух заявок, оно имеет нормальное или равномерное распределение
в некотором интервале (например, от 0 до 20 минут), причем плотность потока
заявок зависит от дня недели, времени дня и цены на бензин. Случайными
величинами (не зависящими от плотности потока заявок) является
объем закупаемого каждым владельцем бензина (от 10 до 50 литров) и его
марка. Длительность обслуживания каждой заявки (заполнение бака
автомашины) зависит от объема закупаемого бензина (1-3 минуты).
Максимально возможная длина очереди около разливочного автомата – N
машин (5≤ N ≤ 9). Если у автомата скопилась максимальная очередь, то вновь
прибывающие автомашины уезжают без обслуживания – тем самым станция
теряет своих потенциальных клиентов. Очереди формируются по определенному
закону – так, что разница между максимальной и минимальной очередью у
автоматов с одним типом бензина не превышает 2 человека.
Цель моделирования работы бензозаправочной станции – определение
торговой наценки на бензин, при которой увеличивается
прибыль от его продажи, а также вычисление необходимых запасов бензина
каждой марки (на день и на неделю). Считается, что торговая наценка может
устанавливаться владельцем станции в пределах от 5 до 15% от базовой
стоимости литра бензина (отдельно для каждой его марки), и каждый процент
наценки уменьшает поток покупателей на 3 %. Прибыль станции зависит от
количества проданного бензина и торговой наценки.
Период моделирования – неделя, шаг – интервал времени от 10 минут до 1
часа. В параметры моделирования следует включить величины K и N, процент
торговой наценки на бензин; диапазоны изменения случайных величин –
временного промежутка между последовательным поступлением заявок на
обслуживание, марки и объема требуемого в каждой заявке бензина.
Визуализация моделируемого процесса должна предусматривать показ
очередей у каждого автомата, приезд и отъезд автомашин, а также вывод
статистической информации о работе станции: количество обслуженных
автомашин и средний объем проданного бензина за день и неделю (по
отдельности для разных марок), количество автомашин, уехавших без заправки,
полученная станцией прибыль.
