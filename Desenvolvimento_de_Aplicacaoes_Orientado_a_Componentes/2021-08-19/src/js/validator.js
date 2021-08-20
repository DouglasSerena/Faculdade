const _rules = {
  required: "valueMissing",
  email: "typeMismatch",
  url: "typeMismatch",
  pattern: "patternMismatch",
  max: "rangeOverflow",
  min: "rangeUnderflow",
  step: "stepMismatch",
  maxlength: "tooLong",
  minlength: "tooShort",
};

window.$validator = function (element, rules) {
  let touched = false;
  const $input = $(element);
  const $container = $input.parent();
  let $message = $container.find(`.invalid-feedback`);
  if (!$message.length) {
    $message = $(`<div class="invalid-feedback"></div>`);
    $container.append($message);
  }

  Object.keys(rules).map((key) => {
    rules[_rules[key]] = rules[key];
    delete rules[key];
  });

  // EVENTS
  $input.on("input", valid);
  $input.on("blur", onBlur);
  $input.on("invalid", onInvalid);

  // EVENT BLUR
  function onBlur(event) {
    touched = true;
    valid(event);
  }

  // EVENT INVALID
  function onInvalid(event) {
    event.preventDefault();
    touched = true;
    valid(event);
  }

  function valid(event) {
    if (!touched) {
      return;
    }

    const validity = event.target.validity;

    $input.removeClass("is-invalid");
    $input.removeClass("is-valid");

    if (validity.valid) {
      return $input.addClass("is-valid");
    }

    for (let key in rules) {
      if (validity[key]) {
        $message.text(rules[key]);
        return $input.addClass("is-invalid");
      }
    }
  }
};
